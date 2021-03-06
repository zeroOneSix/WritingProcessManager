package com.writing.management.WMP.GUI.view;

import java.time.LocalDate;

import com.writing.documents.Submission;
import com.writing.documents.SubmittedResponse;
import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;
import com.writing.documents.factory.SubmissionFactory;
import com.writing.management.WMP.GUI.StartWPM;
import com.writing.management.WMP.GUI.model.ReadyForSubmissionModel;
import com.writing.management.WPM.events.factory.EventFactory;
import com.writing.management.tool.WPMTools.WPMDateTools;
import com.writing.registry.WritingPieceRegistry;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class NewSubmissionController {
	
	private StartWPM mainApp;
	private Stage newSubmissionDialogStage;
	private ReadyForSubmissionModel selectedDraft;
	private boolean newCreated = false;
	
	@FXML
	private TextField pieceToBeSubmittedText;
	@FXML
	private TextField magazineNameText;
	@FXML
	private DatePicker dateSubmittedText;
	

	
	private void initalize() {
	}
	public void setDraftForSubmission(ReadyForSubmissionModel selectedDraft) {
		this.selectedDraft = selectedDraft;
		pieceToBeSubmittedText.setText(selectedDraft.getWritingPieceNameAsString());
	}
	public void setNewSubmissionDialogStage(Stage newSubmissionDialogStage) {
		this.newSubmissionDialogStage = newSubmissionDialogStage;
	}

	@FXML
	private void handleNewSubmission() {
		try {
		boolean validInput = validateInput();
		if(validInput) {
			System.out.println("Creating New Submission...");
			//TODO Create new submission method
			String magazineName = magazineNameText.getText();
			LocalDate localDate = dateSubmittedText.getValue();
			String formatedDate = WPMDateTools.parseDate(localDate);
			String submittedName = formatedDate + "_" + magazineName;
			//Process Fiction Submission
			WritingPiece wp = WritingPieceRegistry.getWritingPieceByID(selectedDraft.getDbIDAsString());
			Submission newSubmission = SubmissionFactory.create(submittedName,SubmittedResponse.PENDING.toString(),wp);
			newSubmission.setMagazineName(magazineName);
			if(selectedDraft.getWritingPieceTypeAsEnum().equals(WritingType.FICTION)) {
				System.out.println("...Creating New Fiction Submission Event");
				//Post new Fiction Draft To Submission Event to Event Bus
				mainApp.postEvent(EventFactory.getFictionNewSubmissionEvent(newSubmission));
			}else if (selectedDraft.getWritingPieceTypeAsEnum().equals(WritingType.POEM)){
				System.out.println("...Creating New Poetry Submission Event");
				//Post new Poetry Draft to Submission Event to Event Bus
				mainApp.postEvent(EventFactory.getPoetryNewSubmissionEvent(newSubmission));
			}else {
				throw new Exception("New Submission Event Cannot be created. No Writing Piece Type found for " + selectedDraft.getWritingPieceNameAsString());
			}
			newCreated = true;
			newSubmissionDialogStage.close();
		}}catch (Exception e) {
			System.out.println("New Submission cannot be created!");
			e.printStackTrace();
		}
		
	}
	@FXML
	private void handleDiscardedSubmissions() {
		newSubmissionDialogStage.close();
	}
	
	/**
	 * Validates the input in the Form before processing any event
	 * 
	 * @return true if input given on the form is valid, false if not
	 */
	private boolean validateInput() {
		String errorMessage = "";
		if(magazineNameText.getText() == null || magazineNameText.getText().length() == 0) {
			errorMessage = "Please enter the name of a magazine";
		}
		if(dateSubmittedText.getValue() == null || dateSubmittedText.getValue().toString().length() == 0) {
			errorMessage = "Please enter a date for the submission";
		}
		if(errorMessage.length() == 0 ) {
			return true;
		}else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(newSubmissionDialogStage);
	            alert.setTitle("Invalid Fields");
	            alert.setHeaderText("Please correct invalid fields");
	            alert.setContentText(errorMessage);
	            alert.showAndWait();
	            return false;
		}
	}
	
	public boolean newCreated() {
		return newCreated;
	}
	public void setMainApp(StartWPM mainApp) {
		this.mainApp = mainApp;
		
	}
}
