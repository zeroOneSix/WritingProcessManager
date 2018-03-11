package com.writing.management.WPM.events.drafts;

import com.writing.documents.WritingPiece;
import com.writing.management.WPM.events.WritingPieceEvent;

public abstract class DocumentToDraftEvent extends WritingPieceEvent {
	public DocumentToDraftEvent(WritingPiece wp){
		super(wp);
	}
}
