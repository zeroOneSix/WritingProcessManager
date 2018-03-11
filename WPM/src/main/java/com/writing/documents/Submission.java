package com.writing.documents;

import java.util.Date;;

public class Submission implements WPMDocument{
	
	private WritingPiece pieceSubmitted;
	private String magazineName;
	private String link;
	private Date dateSubmitted;
	private SubmittedResponse submittedResponse;
	private Date responseDate;
	private String submissionName;
	private String submissionLocation;
	private String dbID;
	
	public Submission()  {
	//TODO Change Sumbission so as to allow more than one piece submitted at a time	
	}
	public Submission(String submissionLocation, String submissionName, SubmittedResponse submittedResponse) {
		this.submissionLocation = submissionLocation;
		this.submissionName = submissionName;
		this.submittedResponse = submittedResponse;
	}
	
	public Submission(String submissionName, String submittedResponse, String dbID, WritingPiece pieceSubmitted, String submissionLocation) {
		this.submissionName = submissionName;
		this.submittedResponse = SubmittedResponse.valueOf(submittedResponse);
		this.pieceSubmitted = pieceSubmitted;
		this.dbID = dbID;
		this.submissionLocation = submissionLocation;
	}
	
	public Submission(String submissionName, String submittedResponse, WritingPiece pieceSubmitted) {
		this.submissionName = submissionName;
		this.submittedResponse = SubmittedResponse.valueOf(submittedResponse);
		this.pieceSubmitted = pieceSubmitted;
	}
	
	public void setDbID(String dbID){
		this.dbID = dbID;
	}
	public String getdbID() {
		return dbID;
	}
	
	public WritingPiece getPieceSubmitted() {
		return pieceSubmitted;
	}
	public void setPieceSubmitted(WritingPiece pieceSubmitted) {
		this.pieceSubmitted = pieceSubmitted;
	}
	public String getMagazineName() {
		return magazineName;
	}
	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public SubmittedResponse getSubmittedResponse() {
		return submittedResponse;
	}
	public void setSubmittedResponse(SubmittedResponse submittedResponse) {
		this.submittedResponse = submittedResponse;
	}
	public Date getResponseDate() {
		return responseDate;
	}
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	public void setSubmissionName(String dirName) {
		this.submissionName = dirName;
		
	}
	public String getSubmissionName() {
		return submissionName;
	}
	public void setSubmissionLocation(String submissionLocation) {
		this.submissionLocation = submissionLocation;		
	}
	
	public String getSubmissionLocation() {
		return submissionLocation;
	}
}
