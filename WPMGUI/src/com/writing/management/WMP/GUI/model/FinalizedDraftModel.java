package com.writing.management.WMP.GUI.model;

import java.nio.file.Path;
import java.time.LocalDate;

import com.writing.documents.WritingType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class FinalizedDraftModel extends WritingPieceModel {
	
	private ObjectProperty<LocalDate> lastModified;
	private Path path;

	public FinalizedDraftModel(String writingPieceName, WritingType writingPieceType) {
		super(writingPieceName, writingPieceType);
	}
	public FinalizedDraftModel(String writingPieceName, LocalDate lastModified, WritingType writingType, Path path) {
		super(writingPieceName, writingType);
		this.lastModified = new SimpleObjectProperty<LocalDate>(lastModified);
		this.path = path;
	}
	public ObjectProperty<LocalDate> getLastModified() {
		return lastModified;
	}
	public void setLastModified(ObjectProperty<LocalDate> lastModified) {
		this.lastModified = lastModified;
	}
	public Path getPath() {
		return path;
	}

}
