package com.writing.management.WPM.events.submissions;

import com.writing.documents.Submission;

public class PoetrySubmissionAcceptedEvent extends DocumentSubmissionAcceptedEvent {
	public PoetrySubmissionAcceptedEvent(Submission s) {
		super(s);
	}
}
