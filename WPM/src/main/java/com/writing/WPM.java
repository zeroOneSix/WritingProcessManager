package com.writing;

import java.io.IOException;

import com.writing.management.WPM.subscribers.drafts.DocumentToDraftSubscriber;
import com.writing.management.WPM.subscribers.review.NewFictionReviewSubscriber;
import com.writing.management.WPM.subscribers.review.NewPoetryReviewSubscriber;
import com.writing.management.WPM.subscribers.submissions.DocumentDraftToReadyForSubmissionSubscriber;
import com.writing.management.WPM.subscribers.submissions.DocumentNewSubmissionSubscriber;
import com.writing.management.WPM.subscribers.submissions.DocumentSubmissionAcceptedSubscriber;
import com.writing.management.WPM.subscribers.submissions.DocumentSubmissionRejectedSubscriber;
import com.writing.management.WPM.watcher.ReviewWatcherProvider;
import com.writing.management.tool.WPMTools.DirectoryLocations;

import bbejeck.nio.files.directory.event.DirectoryEventWatcher;

import com.google.common.eventbus.EventBus;
/**
 * Writing Process Manager initialisation: Sets up the EventBus and registers the various subscribers for the
 * moving of documents from one dir to another. 
 * 
 * It also sets up the File Watcher for the DOCUMENTS_FOR_REVIEW folder
 *
 */
public class WPM 
{
    public static EventBus init() {
    	//SET UP EVENT BUS FOR PROCESSING EVENTS
		EventBus WritingProcessor = new EventBus();
		
		//EVENT HANDLER FOR MOVING PEICE FROM REVIEW TO DRAFT
		DocumentToDraftSubscriber documentToDraftSubscriber = new DocumentToDraftSubscriber();
		WritingProcessor.register(documentToDraftSubscriber);
		
		//EVENT HANDLER FOR MOVING PEICE FROM DRAFT TO READY FOR SUBMISSION
		DocumentDraftToReadyForSubmissionSubscriber documentDraftToSubmissionSubscriber = new DocumentDraftToReadyForSubmissionSubscriber();
		WritingProcessor.register(documentDraftToSubmissionSubscriber);

		
		//EVENT HANDLER FOR SUBMISSIONS
		//NEW SUBMISSION EVENT
		DocumentNewSubmissionSubscriber documentNewSubmissionSubscriber = new DocumentNewSubmissionSubscriber();
		WritingProcessor.register(documentNewSubmissionSubscriber);
		
		//SUCCESSFUL SUBMISSIONS TO PUBLISHED || REJECTED SUBMISSIONS TO REJECTED SUBMISSIONS
		DocumentSubmissionAcceptedSubscriber documentSubmissionAcceptedSubscriber = new DocumentSubmissionAcceptedSubscriber();
		WritingProcessor.register(documentSubmissionAcceptedSubscriber);
		
		DocumentSubmissionRejectedSubscriber documentSubmissionRejectedSubscriber = new DocumentSubmissionRejectedSubscriber();
		WritingProcessor.register(documentSubmissionRejectedSubscriber);
		
		return WritingProcessor;
	}

	public static void startWatcher() {
		EventBus evBus = new EventBus();
		String startPath = DirectoryLocations.getDocumentsForReviewFolder();
		System.out.println("Starting File Watcher...");
		NewFictionReviewSubscriber fictionReviewSubscriber = new NewFictionReviewSubscriber();
		NewPoetryReviewSubscriber poetryReviewSubscriber = new NewPoetryReviewSubscriber();
		evBus.register(poetryReviewSubscriber);
		evBus.register(fictionReviewSubscriber);
		
		ReviewWatcherProvider dewp = new ReviewWatcherProvider(evBus, startPath);
		DirectoryEventWatcher watch = dewp.get();	
		
		try {
			watch.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}