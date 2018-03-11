package com.writing.management.WPM.events.factory;

import java.nio.file.Path;

import com.writing.documents.Submission;
import com.writing.documents.WritingPiece;
import com.writing.management.WPM.events.drafts.FictionDocumentToDraftEvent;
import com.writing.management.WPM.events.drafts.PoetryDocumentToDraftEvent;
import com.writing.management.WPM.events.review.NewFictionForReviewEvent;
import com.writing.management.WPM.events.review.NewPoetryForReviewEvent;
import com.writing.management.WPM.events.submissions.FictionDraftToReadyForSubmissionEvent;
import com.writing.management.WPM.events.submissions.FictionNewSubmissionEvent;
import com.writing.management.WPM.events.submissions.FictionSubmissionAcceptedEvent;
import com.writing.management.WPM.events.submissions.FictionSubmissionRejectedEvent;
import com.writing.management.WPM.events.submissions.PoetryDraftToReadyForSubmissionEvent;
import com.writing.management.WPM.events.submissions.PoetryNewSubmissionEvent;
import com.writing.management.WPM.events.submissions.PoetrySubmissionAcceptedEvent;
import com.writing.management.WPM.events.submissions.PoetrySubmissionRejectedEvent;

public class EventFactory {
	//TODO Create an event factory for the different events required
	//DOCUMENT FOR REVIEW EVENTS
	public static NewFictionForReviewEvent getNewFictionForReviewEvent(Path path) {
		return new NewFictionForReviewEvent(path);
	}
	public static NewPoetryForReviewEvent getNewPoetryForReviewEvent(Path path) {
		return new NewPoetryForReviewEvent(path);
	}
	//REVIEW TO DRAFT EVENTS
	public static FictionDocumentToDraftEvent getFictionDocumentToDraftEvent(WritingPiece wp) {
		return new FictionDocumentToDraftEvent(wp);
	}
	public static PoetryDocumentToDraftEvent getPoetryDocumentToDraftEvent(WritingPiece wp) {
		return new PoetryDocumentToDraftEvent(wp);
	}
	//DRAFT TO READY FOR SUBMISSION EVENTS
	public static FictionDraftToReadyForSubmissionEvent getFictionDraftToSubmissionEvent(WritingPiece wp, Path writingPieceToMove) {
		return new FictionDraftToReadyForSubmissionEvent(wp, writingPieceToMove);	
	}
	public static PoetryDraftToReadyForSubmissionEvent getPoetryDraftToSubmissionEvent(WritingPiece wp, Path writingPieceToMove) {
		return new PoetryDraftToReadyForSubmissionEvent(wp, writingPieceToMove);
	}
	//NEW SUBMISSION EVENTS
	public static FictionNewSubmissionEvent getFictionNewSubmissionEvent(Submission submission) {
		return new FictionNewSubmissionEvent(submission);
	}
	public static PoetryNewSubmissionEvent getPoetryNewSubmissionEvent(Submission submission) {
		return new PoetryNewSubmissionEvent(submission);
	}
	//DOCUMENT SUBMISSION ACCEPTED EVENTS
	public static FictionSubmissionAcceptedEvent getFictionSubmissionAcceptedEvent(Submission submission) {
		return new FictionSubmissionAcceptedEvent(submission);
	}
	public static PoetrySubmissionAcceptedEvent getPoetrySubmissionAcceptedEvent(Submission submission) {
		return new PoetrySubmissionAcceptedEvent(submission);
	}
	//DOCUMENTS SUBMISSION REJECTED EVENTS
	public static FictionSubmissionRejectedEvent getFictionSubmissionRejectedEvent(Submission submission) {
		return new FictionSubmissionRejectedEvent(submission);
	}
	public static PoetrySubmissionRejectedEvent getPoetrySubmissionRejectedEvent(Submission submission) {
		return new PoetrySubmissionRejectedEvent(submission);
	}
}
