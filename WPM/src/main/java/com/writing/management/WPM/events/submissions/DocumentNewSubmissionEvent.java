package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;

public abstract class DocumentNewSubmissionEvent extends SubmissionResponseEvent{
	public DocumentNewSubmissionEvent(Submission s) {
		super(s);
	}
}
