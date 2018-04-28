import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static Location myLocation = null; //to keep track of location
	public static ContainerItem myInventory = null; //to keep track of Inventory

	public static void main(String[] args) {
		myInventory = new ContainerItem("Backpack", "Yours", "Store your items");
		
		Item p = new Item("loc", "human", "lab partner");
		Item q = new Item("knife", "sharp", "Kill a person");
		Item r = new Item("chair", "wood", "To sit");
		Item s = new Item("broom", "weapon", "Sweep the floor");
		
		Location x = new Location("DePauw", "Sophomore");
		x.addItem(p);
		x.addItem(q);
		x.addItem(r);
		x.addItem(s);
		
		ContainerItem a = new ContainerItem("Cabinet", "Kitchen", "Place where you cook");
		ContainerItem b = new ContainerItem("Chest", "Box", "Store valuable things");
		a.addItem(q);
		a.addItem(s);
		b.addItem(p);
		b.addItem(r);
		
		
		Scanner s1;
		System.out.println("***** Welcome to the game! *****\n");
		System.out.println("Type 'look' to see what items are in the location.\n" + 
				"  Type 'examine' followed by the name of the item to learn about the item.\n" +
				"    Type 'quit' to quit the game.\n");
		
		while(true) {
			System.out.print("Type a command: ");
			s1 = new Scanner(System.in);
			String userSentence = s1.nextLine();
			String word[] = userSentence.split(" ");
			
			if(word[0].equals("quit")) {
				//If the command is “quit”, the loop should exit and the program ends
				System.out.println("You have successfully quit the game.");
				break;
			}
			
			switch(word[0]) {
			case "look": {
				//If the command is “look”, print out the description of the location and just the names of each items found there
				if(word.length == 1) {
					System.out.println("The description of the location is: " + x.getDescription());
					System.out.println("The items in the class are: ");
					x.printNames();
					System.out.println();
				}
				else {
					System.out.println("I don't know how to do that. Please try another command listed above. \n");
				}
				break;
			}
			
			case "examine": {
				//If the command is “examine NAME”, get the item with the given name from the location 
				//and print its name and description to the screen.
				
				if(!x.itemPresent(word[1])) {
					System.out.println("Item is not in this location." + "\n" + "Please try again below.");
				}
				else {
					String n = "Name: " + x.returnItem(word[1]).getName();
					n += "\n" + "Description: " + x.returnItem(word[1]).getDescription() + "\n";
					System.out.println(n);
				}
				break;
			}
			
			case "take": {
				//If there is an item with the [name] in your character’s current location, remove this item from
				//the current location and add it to the character’s inventory
				
				
				if(word.length == 2) {
					if(!x.itemPresent(word[1])) {
						System.out.println("Item is not in this location." + "\n" + "Please try again below. \n");
					}
					else {
						System.out.println(x.returnItem(word[1]));
						myInventory.addItem(x.returnItem(word[1]));
						x.removeItem(word[1]);
						System.out.println("The item " + word[1] + " is now in your backpack.");
						System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
					}
				}
				else if(word.length == 4) {
					// If there is an item with the given [name] in the specified [container] at
					//your character’s current location, remove it from the [container] and add it to the character’s inventory (e.g.,
				    //take key from chest)
					
					//if(word[1])
				}
				break;
			}
			
			case "drop": {
			//If there is an item with the given [name] in your character’s inventory, remove it from the
			//character’s inventory and add it to the current location. 
				if(!myInventory.presentItem(word[1])) {
					System.out.println("Item is not in this location." + "\n" + "Please try again below. \n");
				}
				else {
					x.addItem(myInventory.itemReturn(word[1]));
					myInventory.remove(word[1]);
					System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
				}
				
				break;
			}
			
			case "inventory": {
				if (word.length==1) {
					if(myInventory.)
					myInventory.listItems();
				}
				System.out.println("\n");
				
				break;
			}
			
			default: {
				//if nothing else matches this is what you should do.
				//If the command is something else
				System.out.println("I don't know how to do that. Please try another command listed above.\n");
				break;
			}
			};
		}
		
		
	}
		
}

