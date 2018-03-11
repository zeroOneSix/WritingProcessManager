package com.writing.management.WMP.GUI.view;

import com.writing.management.WMP.GUI.StartWPM;

import javafx.fxml.FXML;

public class StartSiteController {

    //Reference to the main application
    private StartWPM mainApp;
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void handleReviewClickEvent() {
		mainApp.showReviewDisplay();
	}
	
	@FXML
	public void handleDraftClickEvent() {
		mainApp.showDraftDisplay();
	}
	
	@FXML
	public void handleSbumissionClickEvent() {
		mainApp.showSubmissionDisplay();
	}
	
	@FXML
	public void handleSubmissionRejectedEvent() {
		mainApp.showSubmissionRejectedDisplay();
	}
	
	@FXML
	public void handleSubmissionPublishedEvent() {
		mainApp.showSubmissionPublishedDisplay();
	}
	
	@FXML
	public void handleDocumentsReadyForSubmissionEvent() {
		mainApp.showReadyForSubmissionDisplay();
	}
	
	@FXML
	public void handleSettingsEvent() {
		mainApp.showSettingsDisplay();
	}
	 public void setMainApp(StartWPM mainApp) {
	    this.mainApp = mainApp;
	}
}
