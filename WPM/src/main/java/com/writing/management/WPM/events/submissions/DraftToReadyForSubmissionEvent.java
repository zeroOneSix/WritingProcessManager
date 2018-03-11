package com.writing.management.WPM.events.submissions;

import java.nio.file.Path;

import com.writing.documents.WritingPiece;
import com.writing.management.WPM.events.WritingPieceEvent;

public abstract class DraftToReadyForSubmissionEvent extends WritingPieceEvent{
	
	private Path writingPieceToMove;
	
	DraftToReadyForSubmissionEvent(WritingPiece wp){
		super(wp);
	}
	public void setWritingPieceToMove(Path writingPieceToMovePath) {
		this.writingPieceToMove = writingPieceToMovePath;
	}
	public Path getWritingPieceToMove() {
		return writingPieceToMove;
	}
}
