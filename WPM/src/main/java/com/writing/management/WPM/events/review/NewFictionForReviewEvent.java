package com.writing.management.WPM.events.review;

import java.nio.file.Path;

public class NewFictionForReviewEvent extends NewDocumentForReviewEvent {
	
	public NewFictionForReviewEvent(Path path) {
		super(path);
	}
}
