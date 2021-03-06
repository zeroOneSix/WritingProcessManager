package com.writing.management.WPM.subscribers.drafts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.common.eventbus.Subscribe;
import com.writing.documents.Status;
import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;
import com.writing.management.WPM.events.drafts.DocumentToDraftEvent;
import com.writing.management.tool.WPMTools.DirectoryLocations;
import com.writing.registry.WritingPieceRegistry;

public class DocumentToDraftSubscriber {
	
	@Subscribe
	public void createNewDraft(DocumentToDraftEvent event) {
		WritingPiece writingPiece = event.getWritingPiece();
		//TODO Create Draft object for audit trail
		try {
		//Find Location of Writing Piece
		Path location = writingPiece.getPath();
		//Get Name of document
		String writingPieceName = writingPiece.getName();
		//Get location for new piece
		Path targetLocation;
		if(WritingType.FICTION == writingPiece.getWritingType()) {
			targetLocation = Paths.get(DirectoryLocations.getDocumentsForDraftingFiction());
		}else {
			targetLocation = Paths.get(DirectoryLocations.getDocumentsForDraftingPoetry());
		}
		String newTargetLocationStr = targetLocation.toString() + "\\" + writingPieceName;
		Path newTargetLocationPath = Paths.get(newTargetLocationStr);
		//Create New Directory
			if(!newTargetLocationPath.toFile().exists()) {
				Files.createDirectory(newTargetLocationPath);
				//Move the Document from DOCUMENTS_FOR_REVIEW to DOCUMENTS_FOR_DRAFT
				//TODO Handle the movement with the file extensions better
				String newWritingPieceLocationStr = newTargetLocationStr + "\\" + writingPieceName +".docx";
				Path newWritingPieceLocationPath = Paths.get(newWritingPieceLocationStr);
				Files.move(location, Paths.get(newTargetLocationStr + "\\"+ writingPieceName + ".docx"));
				//Update Writing Piece in DB
				writingPiece.setPath(newWritingPieceLocationPath);
				writingPiece.setStatus(Status.DOCUMENT_FOR_DRAFTING);
				WritingPieceRegistry.updateWritingPiece(writingPiece);
			}else {
				throw new IOException("Directory already exists");
			}
				
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
