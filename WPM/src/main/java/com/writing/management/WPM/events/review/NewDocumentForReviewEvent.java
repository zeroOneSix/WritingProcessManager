package com.writing.management.WPM.events.review;

import java.nio.file.Path;

public abstract class NewDocumentForReviewEvent {
	private Path path; 

	public NewDocumentForReviewEvent(Path path) {
		this.path = path;
	}
	
	public Path getPath() {
		return path;
	}
}
