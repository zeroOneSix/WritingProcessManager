package com.writing.management.WMP.GUI.view;

import com.writing.documents.Status;
import com.writing.management.WMP.GUI.StartWPM;
import com.writing.management.WMP.GUI.lookups.ItemLookup;
import com.writing.management.WMP.GUI.model.DraftModel;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DraftDisplayController {
	
	@FXML
	private TableView<DraftModel> draftDisplayTable;
	@FXML
	private TableColumn<DraftModel, String> writingNameColumn;
    @FXML
    private TableColumn<DraftModel, String> writingTypeColumn;

	
	private StartWPM mainApp;
	private Stage draftDisplayStage;
	
	public DraftDisplayController() {
		
	}
	
	public void initialize() {
		writingNameColumn.setCellValueFactory(cellData -> cellData.getValue().getWritingPieceName());
		writingTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getWritingPieceTypeAsStringProperty());
		
	}
	
	//TODO Implment this method for moving draft from drafts to ready for submission
	@FXML
	private void handleFinalizeDraftEvent() {
		DraftModel draftSelect = draftDisplayTable.getSelectionModel().getSelectedItem();
		int draftSelectInt = draftDisplayTable.getSelectionModel().getSelectedIndex();
		if(draftSelect != null) {
			boolean selected = mainApp.showFinalizeDraftDisplay(draftSelect);
			if(draftSelectInt >= 0) {
				draftDisplayTable.getItems().remove(draftSelectInt);
	    	}
		}else {
			//Nothing Selected
			//TODO Create a static class to display warnings like this
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Document Selected");
            alert.setContentText("Please select a document from the table.");

            alert.showAndWait();
		}
		
	}

	public void setMainApp(StartWPM mainApp) {
		this.mainApp = mainApp;
		draftDisplayTable.setItems(getItems());
	}

	public void setdraftDisplayStage(Stage draftDisplayStage) {
		this.draftDisplayStage = draftDisplayStage;
	}
	
	private ObservableList<DraftModel> getItems(){
		ObservableList<DraftModel> draftModels = (ObservableList<DraftModel>) ItemLookup.getItems(Status.DOCUMENT_FOR_DRAFTING);
		return draftModels;
	}

}
