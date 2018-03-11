package com.writing.documents.factory;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.writing.documents.Status;
import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;

public class WritingPieceFactory {

	/**
	 * The create method returns a newly created @WritingPiece object, with the correct status, and writing type. If the writing type
	 * can't be identified by the Path a null object is returned
	 * @param p - Path of the document the created @WritingPiece represents
	 * @return - WritingPiece or Null(if the writing type can't be identified.
	 */
	public static WritingPiece create(Path p, Status s) {
		String name = p.toFile().getName();
		//Removes the .docx from documents found in Review Dir
		//TODO Find a better method of treating the name
		if(name.contains(".docx")) {
			System.out.println(name);
			String[] updatedName = name.split(".docx");
			name = updatedName[0];
		}
		if(p.toFile().toString().contains("\\Fiction")){
			return new WritingPiece(name,s,WritingType.FICTION,p );
		}else if(p.toFile().toString().contains("\\Poetry")) {
			return new WritingPiece(name, s, WritingType.POEM, p);
		}else {
			return null;
		}
		
		
	}
	/**
	 * This create method returns a newly created @WritingPiece object with the values
	 * of the strings passed
	 * 
	 * @param name name of writing piece as a string
	 * @param status status of a writing piece as a string
	 * @param type type of a writing piece as a string
	 * @param path path of a writing piece as a string
	 * @return a newly created writing piece
	 */
	public static WritingPiece create(String name, String status, String type, String path) {
		return new WritingPiece(name,Status.valueOf(status), WritingType.valueOf(type), Paths.get(path));
	}
	
	public static WritingPiece create(String name, String status, String type, String path, String dbID) {
		return new WritingPiece(name,Status.valueOf(status), WritingType.valueOf(type), Paths.get(path), dbID);
	}
}

