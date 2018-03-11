package com.writing.documents.factory;

import com.writing.documents.Submission;
import com.writing.documents.SubmittedResponse;
import com.writing.documents.WritingPiece;

public class SubmissionFactory {
	
	//TODO Clean up the Submission Factory and the Submission Object -- make a more formal structure for what can and cannot be created
	
	public static Submission create(String submissionLocation, String submissionName, SubmittedResponse submittedResponse) {
		return new Submission(submissionLocation, submissionName, submittedResponse);
	}
	
	public static Submission create(String submissionName, String submittedResponse, String dbID, WritingPiece pieceSubmitted, String submissionLocation) {
		return new Submission(submissionName, submittedResponse, dbID, pieceSubmitted, submissionLocation);
	}
	
	public static Submission create(String submissionName, String submittedResponse, WritingPiece pieceSubmitted) {
		return new Submission(submissionName, submittedResponse, pieceSubmitted);
	}

}
