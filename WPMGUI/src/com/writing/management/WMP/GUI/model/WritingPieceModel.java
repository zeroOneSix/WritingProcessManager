package com.writing.management.WMP.GUI.model;

import com.writing.documents.WritingType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class WritingPieceModel {
	private StringProperty writingPieceName;
	private ObjectProperty<WritingType> writingPieceType;
	private StringProperty dbID;
	
	public WritingPieceModel(StringProperty writingPieceName, ObjectProperty<WritingType> writingPieceType) {
		this.writingPieceName = writingPieceName;
		this.writingPieceType = writingPieceType;
	}
	
	public WritingPieceModel(String writingPieceName, WritingType writingPieceType) {
		this.writingPieceName = new SimpleStringProperty(writingPieceName);
		this.writingPieceType = new SimpleObjectProperty<WritingType>(writingPieceType);
	}
	
	public WritingPieceModel(StringProperty writingPieceName, ObjectProperty<WritingType> writingPieceType, StringProperty dbID) {
		this.writingPieceName = writingPieceName;
		this.writingPieceType = writingPieceType;
		this.dbID = dbID;
	}
	
	public WritingPieceModel(String writingPieceName, WritingType writingPieceType, String dbID) {
		this.writingPieceName = new SimpleStringProperty(writingPieceName);
		this.writingPieceType = new SimpleObjectProperty<WritingType>(writingPieceType);
		this.dbID = new SimpleStringProperty(dbID);
	}
	

	//Writing Piece Name Methods
	public StringProperty getWritingPieceName() {
		return writingPieceName;
	}

	public void setWritingPieceName(StringProperty writingPieceName) {
		this.writingPieceName = writingPieceName;
	}

	public String getWritingPieceNameAsString() {
		return writingPieceName.get();
	}
	
	public void setWritingPieceNameAsString(String writingPieceName) {
		this.writingPieceName = new SimpleStringProperty(writingPieceName);
	}
	//Writing Piece Type Methods
	public ObjectProperty<WritingType> getWritingPieceType() {
		return writingPieceType;
	}

	public void setWritingPieceType(ObjectProperty<WritingType> writingPieceType) {
		this.writingPieceType = writingPieceType;
	}
	
	public WritingType getWritingPieceTypeAsEnum() {
		return writingPieceType.get();
	}
	
	public void setWritingPieceTypeAsEnum(WritingType writingType) {
		this.writingPieceType = new SimpleObjectProperty<WritingType>(writingType);
	}

	public StringProperty getWritingPieceTypeAsStringProperty() {
		String tmp = writingPieceType.get().toString();
				return new SimpleStringProperty(tmp);
	}
	
	//DB ID Methods
	public void setDbID(StringProperty dbID) {
		this.dbID = dbID;
	}
	public StringProperty getDbID() {
		return dbID;
	}
	
	public void setDbIDAsString(String dbID) {
		this.dbID = new SimpleStringProperty(dbID);
	}
	public String getDbIDAsString() {
		return dbID.get();
	}
}
