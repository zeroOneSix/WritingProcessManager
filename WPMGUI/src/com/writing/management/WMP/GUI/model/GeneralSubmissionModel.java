package com.writing.management.WMP.GUI.model;

import java.time.LocalDate;

import com.writing.management.WMP.GUI.util.DateUtil;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class GeneralSubmissionModel {
	private StringProperty submissionName;
	private StringProperty submittedTo;
	private StringProperty pieceSubmitted;
	private ObjectProperty<LocalDate> dateSubmitted;
	private StringProperty dbID;
	
	public GeneralSubmissionModel(String submissionName, String submittedTo, String pieceSubmitted, LocalDate dateSubmitted, String dbID) {
		this.submissionName = new SimpleStringProperty(submissionName);
		this.submittedTo = new SimpleStringProperty(submittedTo);
		this.pieceSubmitted = new SimpleStringProperty(pieceSubmitted);
		this.dateSubmitted = new SimpleObjectProperty<LocalDate>(dateSubmitted);
		this.dbID = new SimpleStringProperty(dbID);
	}

	//Submission Name Methods
	public StringProperty getSubmissionName() {
		return submissionName;
	}

	public void setSubmissionName(StringProperty submissionName) {
		this.submissionName = submissionName;
	}

	public String getSubmissionNameAsString() {
		return submissionName.get();
	}
	
	public void setSubmissionNameAsString(String submissionName) {
		this.submissionName = new SimpleStringProperty(submissionName);
	}
	
	// Submitted To properties
	public StringProperty getSubmittedTo() {
		return submittedTo;
	}

	public void setSubmittedTo(StringProperty submittedTo) {
		this.submittedTo = submittedTo;
	}
	public String getSubmittedToAsString() {
		return submittedTo.get();
	}
	public void setSubmittedToAsString(String submittedTo) {
		this.submittedTo = new SimpleStringProperty(submittedTo);
	}
	
	//Writing Piece Properties
	public StringProperty getPieceSubmitted() {
		return pieceSubmitted;
	}
	public void setPieceSubmitted(StringProperty pieceSubmitted) {
		this.pieceSubmitted = pieceSubmitted;
	}
	public String getPieceSubmittedAsString() {
		return pieceSubmitted.get();
	}
	public void setPieceSubmittedAsString(String pieceSubmitted) {
		this.pieceSubmitted = new SimpleStringProperty(pieceSubmitted); 
	}

	//Date Submitted
	public ObjectProperty<LocalDate> getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(ObjectProperty<LocalDate> dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public LocalDate getDateSubmittedAsLocalDate() {
		return dateSubmitted.get();
	}
	public void setDateSubmittedAsLocalDate(LocalDate dateSubmitted) {
		this.dateSubmitted = new SimpleObjectProperty<LocalDate>(dateSubmitted);
	}
	public String getDateSubmittedAsString() {
		return DateUtil.format(getDateSubmittedAsLocalDate());
	}
	public StringProperty getDateSubmittedAsStringProperty() {
		return new SimpleStringProperty(DateUtil.format(getDateSubmittedAsLocalDate()));
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
