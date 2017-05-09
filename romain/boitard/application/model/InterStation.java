package romain.boitard.application.model;

public class InterStation {

	private String name;
	private Station station1;
	private Station station2;
	private int distance;
	private int direction1;
	private int direction2;
	private boolean display;
	
	public InterStation(String name, Station station1, Station station2, int dist, int dir1, int dir2){
		this.setName(name);
		this.setStation1(station1);
		this.setStation2(station2);
		this.setDistance(dist);
		this.setDirection1(dir1);
		this.setDirection2(dir2);
		this.setDisplay(true);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Station getStation1(){
		return station1;
	}
	
	public void setStation1(Station station){
		this.station1 = station;
	}
	
	public Station getStation2(){
		return station2;
	}
	
	public void setStation2(Station station){
		this.station2 = station;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	public int getDirection1(){
		return direction1;
	}
	
	public void setDirection1(int direction){
		this.direction1 = direction;
	}
	
	public int getDirection2(){
		return direction2;
	}
	
	public void setDirection2(int direction){
		this.direction2 = direction;
	}

	public boolean getDisplay(){
		return display; 
	}
	
	public void setDisplay(boolean bool) {
		this.display = bool;
		
	}
		
}
