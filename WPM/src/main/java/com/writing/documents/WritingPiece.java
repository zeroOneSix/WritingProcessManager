package com.writing.documents;

import java.nio.file.Path;

public class WritingPiece implements WPMDocument {
	
	private String name;
	private Status status;
	private WritingType writingType;
	private Path path;
	private String dbID;
	
	//TODO Solve and change the structure to solve the problem with status and its ability to be in more than one place(the document)
	public WritingPiece(String name, Status status, WritingType writingType, Path path) {
		this.name = name;
		this.status = status;
		this.path = path;
		this.writingType = writingType;
	}
	
	public WritingPiece(String name, Status status, WritingType writingType, Path path, String dbID) {
		this.name = name;
		this.status = status;
		this.path = path;
		this.writingType = writingType;
		this.dbID = dbID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public Path getPath() {
		return path;
	}
	public void setWritingType(WritingType writingType) {
		this.writingType = writingType;
	}
	public WritingType getWritingType() {
		return writingType;
	}
	
	public void setdbID(String id) {
		this.dbID = id;
	}
	public String getdbID() {
		return dbID;
	}
	
}
