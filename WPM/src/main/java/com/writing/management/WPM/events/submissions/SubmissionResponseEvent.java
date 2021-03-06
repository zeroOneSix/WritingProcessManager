package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;
import com.writing.management.WPM.events.WritingPieceEvent;

public abstract class SubmissionResponseEvent extends WritingPieceEvent {
	
private Submission submission;
	
	public SubmissionResponseEvent(Submission s) {
		super(s.getPieceSubmitted());
		this.submission = s;
	}
	public Submission getSubmission() {
		return submission;
	}
}
