import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	private String name;
	private String description;
	private ArrayList<Item> collections; //collections of Items
	private HashMap<String, Location> direction;
	
	//getHelp method for the driver
	public void getHelp() {
		System.out.println("Type 'look' to see what items are in the location.\n" + 
				"  Type 'examine' followed by the name of the item to learn about the item.\n" +
				"  Type 'inventory' to see what is in your backpack\n" +
				"  Type 'take' and the name of the item at current location to add it to your backpack.\n" + 
				"  Type 'drop' and the name of the item currently in your backpack to drop it from your backpack.\n" +
				"  Type 'take', the name of the item, 'from', and the container current location to add it to your backpack.\n" +
				"  Type 'put', the name of the item, 'in', and the container current location to remove the item from your backpack and add it to the container.\n" +
				"  Type 'go' and the direction you desire to move from one location to another\n" +
				"  Type 'quit' to quit the game.\n");
	}
	
	//Constructor ________________________________________________________________
	public Location(String pName, String pDescription) {
		name = pName;
		description = pDescription;
		collections = new ArrayList<Item>();
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
	
	public boolean containerPresent(String s) {
		//checks if a container contains in the specified location
		
		for(Item e: collections) {
			if(e instanceof ContainerItem) {
				if(s.equals(e.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public ContainerItem returnCon(String s) {
		//returns the ContainerItem by taking in the name of the containerItem as the parameter.
		for(Item e: collections) {
			if(e instanceof ContainerItem) {
				if(s.equals(e.getName())) {
					return ((ContainerItem)e);
				}
			}
		}
		return null;
	}
	
	//*******Methods for HashMap
	
	public void addConnection(String s, Location l) {
		direction.put(s.toLowerCase(),l);
	}
	
	public Location goDirection(String s) {
		if(direction.containsKey(s.toLowerCase())) {
			return direction.get(s.toLowerCase());
		}
		return null;
	}


	
}
