import java.util.ArrayList;

public class Location {
	private String name;
	private String description;
	private ArrayList<Item> collections; //collections of Items
	
	//Constructor
	public Location(String pName, String pDescription) {
		name = pName;
		description = pDescription;
		collections = new ArrayList<Item>();
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	//Setters
	public void setName(String pName) {
		name = pName;
	}
	public void setDescription(String pDescription) {
		description = pDescription;
	}
	
	public void addItem(Item s) {
		// add an Item to the location’s collection
		collections.add(s);
	}
	
	public boolean itemPresent(Item s) { 
		// return whether an item is present in the location’s collection by searching using the item’s name
		for(Item e: collections) {
			if(collections.contains(s)) {
				return true;
			}
		}
			return false;
	}
	
	public Item returnitem(Item d) {
		// return the item (if it’s present) from the location’s collection by searching using the item’s name
		if(itemPresent(d) == true) {
			return d;
		}
		return null;
	}
	
	public int numItems() {
		// get a count of the number of items in the location’s collection.
		int numItems = 0;
		for (Item e: collections) {
			numItems++;
		}
		return numItems;
	}
	
	public Item removeItem(Item s) {
		 //remove (and return) the item within a location’s collection by searching using the item’s name.
		for (Item e: collections) {
			if(collections.contains(s)) {
				return s;
			}
			collections.remove(s);
		}
		return null;
	}
}
