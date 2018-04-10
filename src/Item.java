
public class Item {
	private String name;
	private String type;
	private String description;
	
	public Item(String pName, String pType, String pDescription) {
		name = pName;
		type = pType;
		description = pDescription;
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
