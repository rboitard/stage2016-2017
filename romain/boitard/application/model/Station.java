package romain.boitard.application.model;

public class Station {
	
	private String name;
	private String label;
	private int coordX;
	private int coordY;
	private boolean display;
	
	public Station(String name, String label, int x, int y){
		this.setName(name);
		this.setLabel(label);
		this.setCoordX(x);
		this.setCoordY(y);
		this.setDisplay(true);
	}

	public String getName(){
		return this.name;
	}
	
	public void setName( String name){
		this.name = name;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public void setLabel( String label){
		this.label = label;
	}
	
	public int getCoordX(){
		return this.coordX;
	}
	
	public void setCoordX( int x ){
		this.coordX = x;
	}
	
	public int getCoordY(){
		return this.coordY;
	}
	
	public void setCoordY( int y ){
		this.coordY = y;
	}
	
	private boolean getDisplay() {
		return this.display;
	}
	
	private void setDisplay(boolean bool) {
		this.display = bool;
	}

}
