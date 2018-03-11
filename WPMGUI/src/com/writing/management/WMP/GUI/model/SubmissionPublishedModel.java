package com.writing.management.WMP.GUI.model;

import java.time.LocalDate;

import com.writing.management.WMP.GUI.util.DateUtil;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SubmissionPublishedModel extends GeneralSubmissionModel {

	private ObjectProperty<LocalDate> datePublished; 
	
	public SubmissionPublishedModel(String submissionName, String submittedTo, String pieceSubmitted,
			LocalDate dateSubmitted, LocalDate datePublished, String dbID) {
		super(submissionName, submittedTo, pieceSubmitted, dateSubmitted, dbID);
		this.datePublished = new SimpleObjectProperty<LocalDate>(datePublished);
	}

	//Date Published Methods
	public ObjectProperty<LocalDate> getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(ObjectProperty<LocalDate> datePublished) {
		this.datePublished = datePublished;
	}
	
	public StringProperty getDatePublishedAsStringProperty() {
		return new SimpleStringProperty(DateUtil.format(this.datePublished.get()));
	}
	
}
