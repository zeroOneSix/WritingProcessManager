package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;

public class DocumentSubmissionRejectedEvent extends SubmissionResponseEvent{
	public DocumentSubmissionRejectedEvent(Submission s) {
		super(s);
	}
}
