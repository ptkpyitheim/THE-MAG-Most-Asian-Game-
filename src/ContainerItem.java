import java.util.ArrayList;

public class ContainerItem extends Item {
	
	private ArrayList<Item> myList = new ArrayList<Item>();
	
	
	public ContainerItem(String pName, String pType, String pDescription) {
		//not sure if we need a constructor for this.
		super(pName, pType, pDescription);
		myList = new ArrayList<Item>();
	}
	
	public void addItem(Item s) {
		//A method to add an Item to the collection
		myList.add(s);
	}
	
	public Item remove(String s) {
		//A method to remove and return an Item from the collection when the method is provided the item’s name
		for(Item e: myList) {
			if(e.getName().equals(s)) {
				myList.remove(e);
				return e;
			}
		}
		return null;
	}
	
	//Have to write the method below
	//A method to remove and return Item from the collection when the method is provided the index of the Item to remove
	
	public int itemsCount() {
		//A method that returns a count of how many items are in the collection
		return myList.size();
	}
	
	public boolean presentItem (String s) {
		//A method that returns whether an Item is in the collection when the method is provided the item’s name
		for (Item e: myList) {
			if(e.getName().equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public String getDescription() {
		//A method that overrides the getDescription method to print out the container’s description as well as a list
		//of the item names in the container.
		System.out.println(super.getDescription());
		for(Item e: myList) {
			return e.getName() + "\n";
		}
		return null;
	}
	
	
	
}
