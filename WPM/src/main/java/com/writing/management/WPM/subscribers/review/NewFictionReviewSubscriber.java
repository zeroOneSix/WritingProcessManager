package com.writing.management.WPM.subscribers.review;

import com.google.common.eventbus.Subscribe;
import com.writing.documents.Status;
import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;
import com.writing.management.WPM.events.review.NewFictionForReviewEvent;

public class NewFictionReviewSubscriber {

	@Subscribe
	public void handleNewFictionPiece(NewFictionForReviewEvent event) {
		System.out.println("New fiction piece found");	
		WritingPiece newPiece = new WritingPiece(
				event.getPath().toFile().getName(), Status.DOCUMENT_FOR_REVIEW, WritingType.FICTION, event.getPath());
	}
}
