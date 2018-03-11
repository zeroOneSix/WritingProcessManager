package com.writing.management.WMP.GUI.model;

import java.time.LocalDate;

public class SubmissionModel extends GeneralSubmissionModel {

	public SubmissionModel(String submissionName, String submittedTo, String pieceSubmitted, LocalDate dateSubmitted, String dbID) {
		super(submissionName, submittedTo, pieceSubmitted, dateSubmitted, dbID);
	}
	
}
