package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;

public class FictionNewSubmissionEvent extends DocumentNewSubmissionEvent {
	public FictionNewSubmissionEvent(Submission s) {
		super(s);
	}
}
