
public class Item {
	private String name;
	private String type;
	private String description;
	private boolean state;
	
	public Item(String pName, String pType, String pDescription, boolean view) {
		name = pName;
		type = pType;
		description = pDescription;
		state = view;
	}
	
	//Getters ________________________________________________________________
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public boolean getState(){
		return state;
	}
	
	//Setters ________________________________________________________________
	public void setName(String pName) {
		name = pName;
	}
	public void setType(String pType) {
		type = pType;
	}
	public void setDescription(String pDescription) {
		description = pDescription;
	}
	public void setState(boolean pState){
		state = pState;
	}
	
	//toString() method ________________________________________________________________
	public String toString() {
		String ret = " ";
		ret += "Item: \n";
		ret += "      Name: " + name + "\n";
		ret += "      Type: " + type + "\n";
		ret += "      Description: " + description;
		return ret;
	}
	

}
