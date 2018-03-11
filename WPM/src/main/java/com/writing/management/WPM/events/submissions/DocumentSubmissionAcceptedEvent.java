package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;

public abstract class DocumentSubmissionAcceptedEvent extends SubmissionResponseEvent{
	public DocumentSubmissionAcceptedEvent(Submission s) {
		super(s);
	}
}
