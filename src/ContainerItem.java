import java.util.ArrayList;

public class ContainerItem extends Item {
	
	private ArrayList<Item> myList;
	
	public ContainerItem(String pName, String pType, String pDescription, boolean view) {
		//not sure if we need a constructor for this.
		super(pName, pType, pDescription, view);
		myList = new ArrayList<Item>();
	}
	
	public void addItem(Item s) {
		//A method to add an Item to the collection
		myList.add(s);
	}
	
	
	public Item remove(String s) {
		//A method to remove and return an Item from the collection when the method is provided the item’s name
		for(Item e: myList) {
			if(e.getName().toLowerCase().equals(s.toLowerCase())) {
				myList.remove(e);
				return e;
			}
		}
		return null;
	}
		
	public int itemsCount() {
		//A method that returns a count of how many items are in the collection
		return myList.size();
	}
	
	public boolean presentItem (String s) {
		//A method that returns whether an Item is in the Container when the method is provided the item’s name
		for (Item e: myList) {
			if(e.getName().toLowerCase().equals(s.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public String getDescription() {
		//A method that overrides the getDescription method to print out the container’s description as well as a list
		//of the item names in the container.
		System.out.println("Decription of the container is: " + super.getDescription());
		String ret = "";
		int i = 0;
		if(myList.size()>0) {
			System.out.println("\n The items in " + this.getName() + " are: ");
			for(Item e: myList) {
				i++;
				ret+= i + ") " + e.getName() + "\n";
			}
			return ret;
		}
		else {
			return "You currently don't have any food in the " + this.getName() + ".\n";
		}
	}
	
	public Item itemReturn(String d) {
		// return the item (if it’s present) from the ContainerItem’s ArrayList by searching using the item’s name
		for(Item e: myList) {
			if(e.getName().toLowerCase().equals(d.toLowerCase())) {
				return e;
			}
		}
		return null;
	}
	
	public void listItems() {
		//Prints out all the names of the items in the ContainerItem class.
		int i = 0;	
		for(Item e: myList) {
				i++;
				System.out.println(i + ") " + e.getName());
			}
	}
	
	
}
