package romain.boitard.application.controller;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import romain.boitard.application.MainApp;
import romain.boitard.application.model.StationView;
import romain.boitard.application.model.Station;


public class ViewController {
    
	@FXML 
    private ScatterChart<Number, Number> chart;
	@FXML
	private TextArea log;
	@FXML
	private GridPane GridPaneEdit;

	private MouseGestures mg;
	
	private ViewEditController stationControll; 

    
    // Reference to the main application.
    private MainApp mainApp;

    
    public ViewController() {
    }

    
    @FXML
    private void initialize() {
    	
    	Axis<Number> xAxis = chart.getXAxis();
    	Axis<Number> yAxis = chart.getYAxis();
    	Node chartBackground = chart.lookup(".chart-plot-background");
    	
    	log.setText("Bienvenue");
    	this.mg = new MouseGestures();
    	stationControll = new ViewEditController();
    	System.out.println(GridPaneEdit);
    	//stationControll.addEditStationGridPane(GridPaneEdit);
    	
    	
    	
        // Load person overview.
        //GridPaneEdit.add(EditStationView, 0, 1); 
          
    
    	//ajout d'une nouvelle station au clic de la souris sur le graph
        chartBackground.setOnMouseClicked(new EventHandler<MouseEvent>(){
    		@Override
			public void handle(MouseEvent mouseEvent) {
    			Station station2 = new Station("Sp1", "Sp", Math.round(xAxis.getValueForDisplay(mouseEvent.getX()).floatValue()), Math.round(yAxis.getValueForDisplay(mouseEvent.getY()).floatValue()));
    			createStation(station2);
    			log.appendText("\n" + xAxis.getValueForDisplay(mouseEvent.getX()).intValue() + " / " + yAxis.getValueForDisplay(mouseEvent.getY()).intValue());
    		}

    	});
    }
    
    public void displayStation(Station station){
    	/*stationName.setText(station.getName());
    	stationLabel.setText(station.getLabel());
    	stationCoordX.setText(new Integer(station.getCoordX()).toString());
    	stationCoordY.setText(new Integer(station.getCoordY()).toString());*/
    }
    
	private void createStation(Station station) {
		if( coordFree(station)){
			//ajout à la liste des stations
			//
			StationView circle = new StationView(8, station);
			addOnGraph(circle);
			log.appendText("\n" + "Nouvelle station créée");
		}
		else{
			log.appendText("\n" + "La nouvelle station n'a pas peut être créée : coordonnée déjà occupé");
		}
	}
	
	private void addOnGraph(StationView circle){
		XYChart.Data<Number, Number> dataEntry = new XYChart.Data<>(circle.getStation().getCoordX(), circle.getStation().getCoordY());
	    XYChart.Series<Number, Number> series = new XYChart.Series<>();
	    dataEntry.setNode(circle);
	    series.getData().add(dataEntry);
	    chart.getData().add(series);
	    mg.makeDraggable(circle);	
	}
	
	private boolean coordFree(Station station){
		return true;
	}
    
    //Station listener
    public  class MouseGestures {

        double orgSceneX, orgSceneY;
        double orgTranslateX, orgTranslateY;

        
        public void makeDraggable(Node node) {
            node.setOnMousePressed(circleOnMousePressedEventHandler);
        }
        

        //add pressed event listener on station
        EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

            @Override
			public void handle(MouseEvent mouseEvent) {

                orgSceneX = mouseEvent.getSceneX();
                orgSceneY = mouseEvent.getSceneY();

                if (mouseEvent.getSource() instanceof StationView) {

                	StationView p = ((StationView) (mouseEvent.getSource()));
                	log.appendText( "\n" + p.getStation().getName());
                	displayStation(p.getStation());
                    orgTranslateX = p.getCenterX();
                    orgTranslateY = p.getCenterY();

                }
            }
        };
    }

    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
   
}
