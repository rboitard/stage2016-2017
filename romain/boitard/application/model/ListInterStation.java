package romain.boitard.application.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class ListInterStation{

	private HashMap<String, InterStation> stationList;
	
	public ListInterStation(){
		stationList = new HashMap<String, InterStation>();
		this.loadInterStations();
	}
	
	public void addInterStation(InterStation interStation){
		stationList.put(interStation.getName(), interStation);
	}
	
	public InterStation getInterStation(String name){
		return stationList.get(name);
	}
	
	public boolean InterStationExist(Station InterStation){
		return stationList.containsKey(InterStation.getName());
	}
	
	public ArrayList<InterStation> getAllInterStation(){
		ArrayList<InterStation> list = new ArrayList<InterStation>();
		Set<String> set = this.stationList.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			list.add(stationList.get(it.next()));
		}
		return list;
	}
	

	public void loadInterStations() {
		// TODO Auto-generated method stub
		
	}
	
	public void importFromCSV(){
		
	}
	
	public void exportFromCSV(){
		
	}

}
