package com.writing.management.WMP.GUI.view;

import com.writing.documents.SubmittedResponse;
import com.writing.management.WMP.GUI.StartWPM;
import com.writing.management.WMP.GUI.lookups.SubmissionsLookUp;
import com.writing.management.WMP.GUI.model.SubmissionPublishedModel;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SubmissionPublishedDisplayController {
	
	@FXML
	private TableView<SubmissionPublishedModel> submissionsPublishedDisplayTable;
	@FXML
	private TableColumn<SubmissionPublishedModel, String> submissionPublishedNameColumn;
    @FXML
    private TableColumn<SubmissionPublishedModel, String> writingPieceColumn;
    @FXML
    private TableColumn<SubmissionPublishedModel, String> submissionSubmittedDateColumn;
    @FXML
    private TableColumn<SubmissionPublishedModel, String> submissionAcceptedDateColumn;

	
	private StartWPM mainApp;
	private Stage submissionPublishedDisplayStage;
	
	public SubmissionPublishedDisplayController() {
	}
	public void initialize() {
		writingPieceColumn.setCellValueFactory(cellData -> cellData.getValue().getPieceSubmitted());
		submissionSubmittedDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateSubmittedAsStringProperty());
		submissionAcceptedDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDatePublishedAsStringProperty());
		submissionPublishedNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSubmittedTo());
	}
	public void setMainApp(StartWPM mainApp) {
		this.mainApp = mainApp;
		submissionsPublishedDisplayTable.setItems(getItems());
	}

	public void setSubmissionPublishedDisplayStage(Stage submissionPublishedDisplayStage) {
		this.submissionPublishedDisplayStage = submissionPublishedDisplayStage;
	}
	private ObservableList<SubmissionPublishedModel> getItems() {
		return (ObservableList<SubmissionPublishedModel>) SubmissionsLookUp.getItems(SubmittedResponse.ACCEPTED);
	}
	
}
