package com.writing.management.WPM.subscribers.submissions;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.google.common.eventbus.Subscribe;
import com.writing.documents.Status;
import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;
import com.writing.management.WPM.events.submissions.DraftToReadyForSubmissionEvent;
import com.writing.management.tool.WPMTools.DirectoryLocations;
import com.writing.registry.WritingPieceRegistry;

public class DocumentDraftToReadyForSubmissionSubscriber {
	
	WritingPiece wp;
	Path writingPieceToMove;
	Path writingLibTargetLocation;
	
	@Subscribe
	public void readyForSubmission(DraftToReadyForSubmissionEvent event) {
		this.wp = event.getWritingPiece();
		this.writingPieceToMove = event.getWritingPieceToMove();
		moveWritingPiece();
		moveDraftFolderToWritingLibrary();
		updateWritingPiece();
	}
	
	public void moveWritingPiece(){
		try {
			String writingPieceName = wp.getName();
			Path targetLocation;
			if(wp.getWritingType() == WritingType.FICTION) {
				targetLocation = Paths.get(DirectoryLocations.getFictionDocumentsForSubmissionFolder());

			}else {
				targetLocation = Paths.get(DirectoryLocations.getPoetryDocumentsForSubmissionFolder());
			}
			if(targetLocation != null) {
				String newWritingPieceLocationStr = targetLocation.toString() + "\\" + writingPieceName +".docx";
				Path newWritingPieceLocation = Paths.get(newWritingPieceLocationStr);
				System.out.println(newWritingPieceLocationStr);
				FileUtils.copyFile(writingPieceToMove.toFile(), newWritingPieceLocation.toFile());
			}else {
				throw new IOException("failed to find the target folder for " + writingPieceName);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void moveDraftFolderToWritingLibrary() {
		try {
		String draftFolderDir;
		if(wp.getWritingType() == WritingType.FICTION) {
			draftFolderDir = DirectoryLocations.getWritingLibraryFiction();
		}else {
			draftFolderDir = DirectoryLocations.getWritingLibraryPoetry();
		}
		writingLibTargetLocation = Paths.get(draftFolderDir + "\\" + wp.getName() );
		
		FileUtils.moveDirectory(wp.getPath().toFile(), writingLibTargetLocation.toFile());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateWritingPiece() {
		wp.setPath(writingLibTargetLocation);
		wp.setStatus(Status.READY_FOR_SUBMISSION);
		WritingPieceRegistry.updateWritingPiece(wp);
	}
}
