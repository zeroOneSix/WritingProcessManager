package com.writing.management.tool.WPMTools;

import java.util.ArrayList;
import java.util.List;

public class DirectoryLocations {
	
	static String DOCUMENTS_FOR_REVIEW = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\1. DOCUMENTS_FOR_REVIEW";
	static String DOCUMENTS_FOR_REVIEW_FICTION = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\1. DOCUMENTS_FOR_REVIEW\\Fiction";
	static String DOCUMENTS_FOR_REVIEW_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\1. DOCUMENTS_FOR_REVIEW\\Poetry";
	
	static String DOCUMENTS_FOR_DRAFTING_FICTON = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\2. DOCUMENTS_FOR_DRAFTING\\Fiction";
	static String DOCUMENTS_FOR_DRAFTING_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\2. DOCUMENTS_FOR_DRAFTING\\Poetry";
	
	static String DOCUMENTS_FOR_SUBMISSION_FICTION = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\3. DOCUMENTS_FOR_SUBMISSION\\Fiction";
	static String DOCUMENTS_FOR_SUBMISSION_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\3. DOCUMENTS_FOR_SUBMISSION\\Poetry";
	
	static String SUBMITTED_DOCUMENTS_FICTION = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\4. SUBMITTED_DOCUMENTS\\Fiction";
	static String SUBMITTED_DOCUMENTS_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\4. SUBMITTED_DOCUMENTS\\Poetry";
	
	static String REJECTED_SUBMISSIONS_FICTION = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\6. REJECTED_SUBMISSION\\Fiction";
	static String REJECTED_SUBMISSIONS_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\6. REJECTED_SUBMISSION\\Poetry";
	
	static String DOCUMENTS_PUBLISHED_FICTION = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\5. DOCUMENTS_PUBLISHED\\Fiction";
	static String DOCUMENTS_PUBLISHED_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\5. DOCUMENTS_PUBLISHED\\Poetry";
	
	static String WRITING_LIBRARY_FICTION = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\9. WRITING_LIBRARY\\Fiction";
	static String WRITING_LIBRARY_POETRY = "C:\\Users\\stephencuthbertson\\Documents\\developmentWorkspace\\9. WRITING_LIBRARY\\Poem";

	//Writing Library
	public static String getWritingLibraryFiction() {
		return WRITING_LIBRARY_FICTION;
	}
	public static String getWritingLibraryPoetry() {
		return WRITING_LIBRARY_POETRY;
	}
	
	//DOCUMENTS FOR REVIEW
	public static String getDocumentsForReviewFiction() {
		return DOCUMENTS_FOR_REVIEW_FICTION;
	}

	public static String getDocumentsForReviewPoetry() {
		return DOCUMENTS_FOR_REVIEW_POETRY;	
	}
	public static String getDocumentsForReviewFolder() {
		return DOCUMENTS_FOR_REVIEW;
	}
	
	//DOCUMENTS FOR DRAFTING
	public static String getDocumentsForDraftingFiction() {
		return DOCUMENTS_FOR_DRAFTING_FICTON;
	}
	public static String getDocumentsForDraftingPoetry() {
		return DOCUMENTS_FOR_DRAFTING_POETRY;
	}
	
	//DOCUMENTS FOR SUBMISSION
	public static String getFictionDocumentsForSubmissionFolder() {
		return DOCUMENTS_FOR_SUBMISSION_FICTION;
	}
	public static String getPoetryDocumentsForSubmissionFolder() {
		return DOCUMENTS_FOR_SUBMISSION_POETRY;
	}
	
	//DOCUMENTS SUBMITTED
	public static String getSubmittedFictionDocumentsFolder() {
		return SUBMITTED_DOCUMENTS_FICTION;
	}
	public static String getSubmittedPoetryDocumentsFolder() {
		return SUBMITTED_DOCUMENTS_POETRY;
	}
	
	//REJECTED SUBMISSIONS
	public static String getRejectedSubmissionFictionFolder() {
		return REJECTED_SUBMISSIONS_FICTION;
	}
	public static String getRjectedSubmissionPoetryFolder() {
		return REJECTED_SUBMISSIONS_POETRY;
	}
	
	//ACCEPTED SUBMISSIONS - PUBLISHED DOCUMENTS
	public static String getPublishedFictionFolder() {
		return DOCUMENTS_PUBLISHED_FICTION;
	}
	public static String getPublishedPoetryFolder() {
		return DOCUMENTS_PUBLISHED_POETRY;
	}
	
	//ALL DIRECTORY LOCATIONS
	public static List<String> getDirLocations() {
	List<String> dirLocations = new ArrayList<String>();
	
	dirLocations.add(DOCUMENTS_FOR_REVIEW_FICTION);
	dirLocations.add(DOCUMENTS_FOR_REVIEW_POETRY);

	dirLocations.add(DOCUMENTS_FOR_DRAFTING_FICTON);
	dirLocations.add(DOCUMENTS_FOR_DRAFTING_POETRY);

	dirLocations.add(SUBMITTED_DOCUMENTS_FICTION);
	dirLocations.add(SUBMITTED_DOCUMENTS_POETRY);

	dirLocations.add(REJECTED_SUBMISSIONS_FICTION);
	dirLocations.add(REJECTED_SUBMISSIONS_POETRY);

	dirLocations.add(DOCUMENTS_PUBLISHED_FICTION);
	dirLocations.add(DOCUMENTS_PUBLISHED_POETRY);

	dirLocations.add(WRITING_LIBRARY_FICTION);
	dirLocations.add(WRITING_LIBRARY_POETRY);

	return dirLocations;
	}

}
