package com.writing.management.WMP.GUI.model;

import java.time.LocalDate;

import com.writing.management.WMP.GUI.util.DateUtil;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SubmissionRejectedModel extends GeneralSubmissionModel{

	private ObjectProperty<LocalDate> dateRejected;
	
	public SubmissionRejectedModel(String submissionName, String submittedTo, String pieceSubmitted,
			LocalDate dateSubmitted, LocalDate dateRejected, String dbID) {
		super(submissionName, submittedTo, pieceSubmitted, dateSubmitted, dbID);
		this.dateRejected = new SimpleObjectProperty<LocalDate>(dateRejected);
	}

	//Date Rejected Methods
	public ObjectProperty<LocalDate> getDateRejected() {
		return dateRejected;
	}

	public void setDateRejected(ObjectProperty<LocalDate> dateRejected) {
		this.dateRejected = dateRejected;
	}
	
	public StringProperty getdateRejectedAsStringProperty() {
		return new SimpleStringProperty(DateUtil.format(dateRejected.get()));
	}
	
	

}
