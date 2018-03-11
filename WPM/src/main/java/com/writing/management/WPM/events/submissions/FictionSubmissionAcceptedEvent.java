package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;

public class FictionSubmissionAcceptedEvent extends DocumentSubmissionAcceptedEvent {
	public FictionSubmissionAcceptedEvent(Submission s) {
		super(s);
	}
}
