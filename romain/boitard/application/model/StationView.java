package romain.boitard.application.model;

import javafx.scene.shape.Circle;

public class StationView extends Circle{

	private Station station;
	
	public StationView(int length, Station station){
		super(length);
		this.station = station;
	}
	
	public Station getStation(){
		return this.station;
	}
	
}
