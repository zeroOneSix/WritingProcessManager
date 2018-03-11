package com.writing.management.WMP.GUI.view;

import com.writing.documents.Submission;
import com.writing.documents.SubmittedResponse;
import com.writing.documents.WritingType;
import com.writing.management.WMP.GUI.StartWPM;
import com.writing.management.WMP.GUI.lookups.SubmissionsLookUp;
import com.writing.management.WMP.GUI.model.SubmissionModel;
import com.writing.management.WPM.events.factory.EventFactory;
import com.writing.registry.SubmissionRegistry;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SubmissionDisplayController {
	@FXML
	private TableView<SubmissionModel> submissionsDisplayTable;
	@FXML
	private TableColumn<SubmissionModel, String> submissionNameColumn;
    @FXML
    private TableColumn<SubmissionModel, String> writingPieceColumn;
    @FXML
    private TableColumn<SubmissionModel, String> submissionDateColumn;

	
	private StartWPM mainApp;
	private Stage submissionDisplayStage;
	
	public SubmissionDisplayController() {
	}
	
	public void initialize() {
		submissionNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSubmittedTo());
		submissionDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateSubmittedAsStringProperty());
		writingPieceColumn.setCellValueFactory(cellData -> cellData.getValue().getPieceSubmitted());
		
	}
	
	public void setMainApp(StartWPM mainApp) {
		this.mainApp = mainApp;
		submissionsDisplayTable.setItems(getItems());
	}

	public void setSubmissionDisplayStage(Stage draftDisplayStage) {
		this.submissionDisplayStage = draftDisplayStage;
	}
	
	@FXML
	private void handleAcceptSubmission() {
		SubmissionModel selectedSubmission = submissionsDisplayTable.getSelectionModel().getSelectedItem();
		int selectedSubmissionInt = submissionsDisplayTable.getSelectionModel().getSelectedIndex();
		try {
			if(selectedSubmission != null) {
				Submission acceptedSubmission = SubmissionRegistry.getSubmissionByID(selectedSubmission.getDbIDAsString());
				if(acceptedSubmission.getPieceSubmitted().getWritingType() == WritingType.FICTION) {
					mainApp.postEvent(EventFactory.getFictionSubmissionAcceptedEvent(acceptedSubmission));
				}else if(acceptedSubmission.getPieceSubmitted().getWritingType() == WritingType.POEM) {
					mainApp.postEvent(EventFactory.getPoetrySubmissionAcceptedEvent(acceptedSubmission));
				}else {
					throw new Exception("Selected Submission has now writing type");
				}
				removeSelectedItem(selectedSubmissionInt);
			}
			else {
				displayWarning();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleRejectSubmission() {
		SubmissionModel selectedSubmission = submissionsDisplayTable.getSelectionModel().getSelectedItem();
		int selectedSubmissionInt = submissionsDisplayTable.getSelectionModel().getSelectedIndex();

		try {
			if(selectedSubmission != null) {
				Submission rejectedSubmission = SubmissionRegistry.getSubmissionByID(selectedSubmission.getDbIDAsString());
				if(rejectedSubmission.getPieceSubmitted().getWritingType() == WritingType.FICTION) {
					mainApp.postEvent(EventFactory.getFictionSubmissionRejectedEvent(rejectedSubmission));
				}else if(rejectedSubmission.getPieceSubmitted().getWritingType() == WritingType.POEM) {
					mainApp.postEvent(EventFactory.getPoetrySubmissionRejectedEvent(rejectedSubmission));
				}else {
					throw new Exception("Selected Submission has now writing type");
				}
				removeSelectedItem(selectedSubmissionInt);
			}
			else {
				displayWarning();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void removeSelectedItem(int index) {
		if(index >=0) {
			submissionsDisplayTable.getItems().remove(index);
		}
	}
	private void displayWarning() {
		//Nothing Selected
		Alert alert = new Alert(AlertType.WARNING);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("No Selection");
		alert.setHeaderText("No submission Piece Selected");
		alert.setContentText("Please select an item from the table.");
		alert.showAndWait();
	}
	private ObservableList<SubmissionModel> getItems(){
		return (ObservableList<SubmissionModel>) SubmissionsLookUp.getItems(SubmittedResponse.PENDING);
	}

}

