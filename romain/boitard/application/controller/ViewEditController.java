package romain.boitard.application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class ViewEditController {
	
	@FXML
	private TextField stationName;
	@FXML
	private TextField stationLabel;
	@FXML
	private TextField stationCoordX;
	@FXML
	private TextField stationCoordY;
	@FXML
	private ToggleButton stationDisplay;
	@FXML
	private GridPane GridPaneEditStation;

	public ViewEditController() {
	}

	    
	@FXML
	private void initialize() {
		
	}
	
	public void addEditStationGridPane(GridPane gridPane){
		gridPane.add(GridPaneEditStation, 0, 1);
	}
	    
}
