package com.writing.management.WPM.events.submissions;

import java.nio.file.Path;

import com.writing.documents.WritingPiece;

public class PoetryDraftToReadyForSubmissionEvent extends DraftToReadyForSubmissionEvent {
	public PoetryDraftToReadyForSubmissionEvent(WritingPiece wp, Path writingPieceToMovePath) {
		super(wp);
		super.setWritingPieceToMove(writingPieceToMovePath);
	}
}
