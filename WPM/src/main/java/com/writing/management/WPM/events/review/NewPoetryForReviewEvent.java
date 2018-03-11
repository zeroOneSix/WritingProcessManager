package com.writing.management.WPM.events.review;

import java.nio.file.Path;

public class NewPoetryForReviewEvent extends NewDocumentForReviewEvent {

	public NewPoetryForReviewEvent(Path path) {
		super(path);
	}
}
