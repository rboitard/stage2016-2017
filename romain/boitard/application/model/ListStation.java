package romain.boitard.application.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class ListStation{

	private HashMap<String, Station> stationList;
	
	public ListStation(){
		stationList = new HashMap<String, Station>();
		this.loadStations();
	}
	
	public void addStation(Station station){
		stationList.put(station.getName(), station);
	}
	
	public Station getStation(String name){
		return stationList.get(name);
	}
	
	public boolean stationExist(Station station){
		return stationList.containsKey(station.getName());
	}
	
	public ArrayList<Station> getAllStation(){
		ArrayList<Station> list = new ArrayList<Station>();
		Set<String> set = this.stationList.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			list.add(stationList.get(it.next()));
		}
		return list;
	}
	

	public void loadStations() {
		// TODO Auto-generated method stub
		
	}
	
	public void importFromCSV(){
		
	}
	
	public void exportFromCSV(){
		
	}

}
