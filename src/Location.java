import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	private String name;
	private String description;
	private ArrayList<Item> collections; //collections of Items
	private ArrayList<ContainerItem> containerLoc;
	private HashMap<String, Location> direction;
	
	//Constructor ________________________________________________________________
	public Location(String pName, String pDescription) {
		name = pName;
		description = pDescription;
		collections = new ArrayList<Item>();
		containerLoc = new ArrayList<ContainerItem>();
		direction = new HashMap<String, Location>();
	}
	
	//Getters ________________________________________________________________
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	//Setters ________________________________________________________________
	public void setName(String pName) {
		name = pName;
	}
	public void setDescription(String pDescription) {
		description = pDescription;
	}
	
	//Methods ________________________________________________________________
	
	public void addItem(Item s) {
		// add an Item to the location’s collection
		collections.add(s);
	}
	
	public boolean itemPresent(String s) { 
		// return whether an item is present in the location’s collection by searching using the item’s name
		for(Item e: collections) {
			if(e.getName().equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public Item returnItem(String d) {
		// return the item (if it’s present) from the location’s collection by searching using the item’s name
		for(Item e: collections) {
			if(e.getName().equals(d)) {
				return e;
			}
		}
		return null;
	}
	
	public int numItems() {
		// get a count of the number of items in the location’s collection.
		return collections.size();
	}
	
	public Item removeItem(String s) {
		 //remove (and return) the item within a location’s collection by searching using the item’s name.
		for (Item e: collections) {
			if(e.getName().equals(s)) {
				collections.remove(e);
				return e;
			}
		}
		return null;
	}
	
	public void printNames() {
		//Prints out all the names of the items in the location class.
		int i = 0;	
		for(Item e: collections) {
				i++;
				System.out.println(i + ") " + e.getName());
			}
	}
	
	//**** Below codes are for the container
	
	public void addContainer(ContainerItem s) {
		containerLoc.add(s);
	}
	
	public boolean containerPresent(String s) {
		//checks if a container contains in the specified location
		
		for(ContainerItem e: containerLoc) {
			if(s.equals(e.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public ContainerItem returnCon(String s){
		for(ContainerItem e: containerLoc){
			if(s.equals(e.getName())){
				return e;
			}
		}
		return null;
	}
	
}
