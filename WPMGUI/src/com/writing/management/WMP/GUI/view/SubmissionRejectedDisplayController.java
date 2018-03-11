package com.writing.management.WMP.GUI.view;

import com.writing.documents.SubmittedResponse;
import com.writing.management.WMP.GUI.StartWPM;
import com.writing.management.WMP.GUI.lookups.SubmissionsLookUp;
import com.writing.management.WMP.GUI.model.SubmissionRejectedModel;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SubmissionRejectedDisplayController {

	@FXML
	private TableView<SubmissionRejectedModel> submissionsRejctedDisplayTable;
	@FXML
	private TableColumn<SubmissionRejectedModel, String> submissionRejectedNameColumn;
    @FXML
    private TableColumn<SubmissionRejectedModel, String> writingPieceColumn;
    @FXML
    private TableColumn<SubmissionRejectedModel, String> submissionSubmittedDateColumn;
    @FXML
    private TableColumn<SubmissionRejectedModel, String> submissionRejectedDateColumn;

	
	private StartWPM mainApp;
	private Stage submissionRejectedDisplayStage;
	
	public SubmissionRejectedDisplayController() {
		
	}
	public void initialize() {
		writingPieceColumn.setCellValueFactory(cellData -> cellData.getValue().getPieceSubmitted());
		submissionSubmittedDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateSubmittedAsStringProperty());
		submissionRejectedDateColumn.setCellValueFactory(cellData -> cellData.getValue().getdateRejectedAsStringProperty());
		submissionRejectedNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSubmittedTo());
	}
	
	public void setMainApp(StartWPM mainApp) {
		this.mainApp = mainApp;
		submissionsRejctedDisplayTable.setItems(getItems());
	}

	public void setSubmissionRejectedDisplayStage(Stage submissionRejectedDisplayStage) {
		this.submissionRejectedDisplayStage = submissionRejectedDisplayStage;
	}
	
	private ObservableList<SubmissionRejectedModel> getItems(){
		return (ObservableList<SubmissionRejectedModel>) SubmissionsLookUp.getItems(SubmittedResponse.REJECTED);
	}
}
