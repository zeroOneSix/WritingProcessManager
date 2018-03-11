package com.writing.management.WPM.subscribers.submissions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.google.common.eventbus.Subscribe;
import com.writing.documents.Status;
import com.writing.documents.Submission;
import com.writing.documents.SubmittedResponse;
import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;
import com.writing.management.WPM.events.submissions.DocumentSubmissionAcceptedEvent;
import com.writing.management.tool.WPMTools.DirectoryLocations;
import com.writing.registry.SubmissionRegistry;
import com.writing.registry.WritingPieceRegistry;

public class DocumentSubmissionAcceptedSubscriber {
	
	private Submission submission;
	private WritingPiece wp;
	
	@Subscribe
	public void acceptSubmission(DocumentSubmissionAcceptedEvent event) {
		this.submission = event.getSubmission();
		this.wp = submission.getPieceSubmitted();
		moveSubmission();
	}
	private void moveSubmission() {
		try {
		String targetDirLocation;
		if(wp.getWritingType() == WritingType.FICTION) {
			targetDirLocation = DirectoryLocations.getPublishedFictionFolder();
		}else {
			targetDirLocation = DirectoryLocations.getPublishedPoetryFolder();
		}
		String targetLocation = targetDirLocation + "\\" + submission.getSubmissionName();
		File source = Paths.get(submission.getSubmissionLocation()).toFile();
		File dest = Paths.get(targetLocation).toFile();
		FileUtils.moveDirectory(source, dest);
		submission.setSubmittedResponse(SubmittedResponse.ACCEPTED);
		submission.setSubmissionLocation(targetLocation);
		//TODO improve on this path creation by finding the actual file in dir
		//TODO Add error checking and validation -- if there are two pieces of the same title waiting
		String upatedWritingPiecePath = targetLocation + "\\" + wp.getName() + ".docx";
		Files.delete(wp.getPath());
		wp.setPath(Paths.get(upatedWritingPiecePath));
		wp.setStatus(Status.DOCUMENTS_PUBLISHED);
		WritingPieceRegistry.updateWritingPiece(wp);
		SubmissionRegistry.updateSubmission(submission);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}	
}
