package com.writing.management.WPM.events.drafts;

import com.writing.documents.WritingPiece;

public class PoetryDocumentToDraftEvent extends DocumentToDraftEvent {
	public PoetryDocumentToDraftEvent(WritingPiece wp) {
		super(wp);
	}
}
