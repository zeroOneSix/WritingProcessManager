package com.writing.management.WMP.GUI.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.writing.documents.WritingPiece;
import com.writing.documents.WritingType;
import com.writing.management.WMP.GUI.StartWPM;
import com.writing.management.WMP.GUI.model.DraftModel;
import com.writing.management.WMP.GUI.model.FinalizedDraftModel;
import com.writing.management.WPM.events.factory.EventFactory;
import com.writing.management.tool.WPMTools.FileManagementTools;
import com.writing.mangement.WPM.install.traverse.writingPieces.ScanForSubmissionDirectory;
import com.writing.registry.WritingPieceRegistry;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FinalizeDraftDisplayController {
	
	@FXML
	private TableView<FinalizedDraftModel> finalizeDraftDisplayTable;
	@FXML
	private TableColumn<FinalizedDraftModel, String> nameColumn;
	@FXML
	private TableColumn<FinalizedDraftModel, LocalDate> lastModColumn;
	@FXML
	private Label titleLabel;
	
	private StartWPM mainApp;
	private Stage finalizeDraftDisplayStage;
	private DraftModel draftSelected;
	private boolean selected = false;
	
	
	public FinalizeDraftDisplayController() {
	}
	
	public void initilize() {
	}
	
	public void setMainApp(StartWPM mainApp) {
		this.mainApp = mainApp;	
	}
	public void setFinalizeDraftDisplayStage(Stage finalizeDraftDisplayStage) {
		this.finalizeDraftDisplayStage = finalizeDraftDisplayStage;
	}
	
	public void setDraftSelected(DraftModel draftSelected) {
		this.draftSelected = draftSelected;
		titleLabel.setText(draftSelected.getWritingPieceNameAsString());
		finalizeDraftDisplayTable.setItems(getDrafts());	
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getWritingPieceName());
		lastModColumn.setCellValueFactory(cellData -> cellData.getValue().getLastModified());
	}
	
	@FXML
	private void handleCancelEvent() {
		finalizeDraftDisplayStage.close();
	}
	
	@FXML
	private void handleSelectedDraftEvent() {
		FinalizedDraftModel draftToMove = finalizeDraftDisplayTable.getSelectionModel().getSelectedItem();
		
		try {
			if(draftToMove != null) {
				WritingPiece wp = WritingPieceRegistry.getWritingPieceByID(draftSelected.getDbIDAsString());
				
				if(wp.getWritingType() == WritingType.FICTION) {
					mainApp.postEvent(EventFactory.getFictionDraftToSubmissionEvent(wp, draftToMove.getPath()));
				
				}else if(wp.getWritingType() == WritingType.POEM) {
					mainApp.postEvent(EventFactory.getPoetryDraftToSubmissionEvent(wp,draftToMove.getPath()));
				}else {
					throw new Exception();
				}
				finalizeDraftDisplayStage.close();
			}else {
				//Nothing Selected
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.initOwner(mainApp.getPrimaryStage());
    			alert.setTitle("No Selection");
    			alert.setHeaderText("No Draft Selected");
    			alert.setContentText("Please select an item from the table.");
    			alert.showAndWait();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean selected() {
		return selected;
	}
	
	public ObservableList<FinalizedDraftModel> getDrafts(){
		ObservableList<FinalizedDraftModel> drafts = FXCollections.observableArrayList();
		//Get A list of all documents in draft directory
		WritingPiece wp = WritingPieceRegistry.getWritingPieceByID(draftSelected.getDbIDAsString());
		try {
			Set<Path> allDrafts = FileManagementTools.scanDirForFiles(wp.getPath());
			for(Path p : allDrafts) {
				//FIX THE WIERD TIME/DATE
				LocalDate dateLastMod = Instant.ofEpochSecond(p.toFile().lastModified()).atZone(ZoneId.systemDefault()).toLocalDate();
				FinalizedDraftModel draft = new FinalizedDraftModel(p.toFile().getName(),dateLastMod,wp.getWritingType(), p);
				drafts.add(draft);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drafts;
	}
}
