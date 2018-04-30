import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	public static Location myLocation = null; //to keep track of location
	public static ContainerItem myInventory = null; //to keep track of Inventory
	
	//private static HashMap<String, String> mapLoc; //maps Location with ContainerItems

	public static void main(String[] args) {
		
		myLocation = new Location(" ", " ");
		myInventory = new ContainerItem("Backpack", "Yours", "Store your items");
		
		Item p = new Item("loc", "human", "lab partner");
		Item q = new Item("knife", "sharp", "Kill a person");
		Item r = new Item("chair", "wood", "To sit");
		Item s = new Item("broom", "weapon", "Sweep the floor");
		
		Location x = new Location("DePauw", "Sophomore");
		/*
		x.addItem(p);
		x.addItem(q);
		x.addItem(r);
		x.addItem(s);
		*/
		
		ContainerItem a = new ContainerItem("Cabinet", "Kitchen", "Place where you cook");
		ContainerItem b = new ContainerItem("Blah", "Box", "Store valuable things");
		a.addItem(q);
		a.addItem(s);
		
		b.addItem(p);
		b.addItem(r);
		
		x.addContainer(a);
		x.addContainer(b);
		
		
		Scanner s1;
		System.out.println("***** Welcome to the game! *****\n");
		System.out.println("Type 'look' to see what items are in the location.\n" + 
				"  Type 'examine' followed by the name of the item to learn about the item.\n" +
				"    Type 'quit' to quit the game.\n");
		myLocation = x;
		
		
		while(true) {
			System.out.print("Type a command: ");
			s1 = new Scanner(System.in);
			String userSentence = s1.nextLine();
			String word[] = userSentence.split(" ");
			
			if(word[0].equals("quit")) {
				//If the command is “quit”, the loop should exit and the program ends
				if(word.length==1) {
					System.out.println("You have successfully quit the game.");
					break;
				}
			}
			
			switch(word[0]) {
			case "look": {
				//If the command is “look”, print out the description of the location and just the names of each items found there
				if(word.length == 1) {
					System.out.println("The description of the location is: " + x.getDescription());
					System.out.println("The items in the class are: ");
					myLocation.printNames();
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
				
				if(!myLocation.itemPresent(word[1])) {
					System.out.println("Item is not in this location." + "\n" + "Please try again below. \n");
				}
				else {
					String n = "Name: " + myLocation.returnItem(word[1]).getName();
					n += "\n" + "Description: " + myLocation.returnItem(word[1]).getDescription() + "\n";
					System.out.println(n);
				}
				break;
			}
			
			case "take": {
				//If there is an item with the [name] in your character’s current location, remove this item from
				//the current location and add it to the character’s inventory
				
				if(word.length == 2) {
					if(!myLocation.itemPresent(word[1])) {
						System.out.println("Item is not in this location." + "\n" + "Please try again below. \n");
					}
					else {
						System.out.println(myLocation.returnItem(word[1]));
						myInventory.addItem(myLocation.returnItem(word[1]));
						myLocation.removeItem(word[1]);
						System.out.println("The item " + word[1] + " is now in your backpack.");
						System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
						System.out.println("The item(s) in your backpack are: ");
						myInventory.listItems();
						System.out.println();
					}
				}
				else if(word.length == 4 && word[2].equals("from")) {
					// If there is an item with the given [name] in the specified [container] at
					//your character’s current location, remove it from the [container] and add it to the character’s inventory (e.g.,
				    //take key from chest)
				
					if(myLocation.containerPresent(word[3])) {
						if(myLocation.returnCon(word[3]).presentItem(word[1])){
							myInventory.addItem(myLocation.returnCon(word[3]).itemReturn(word[3]));
							myLocation.returnCon(word[3]).remove(word[1]);
							System.out.println("The item " + word[1] + " is now in your backpack.");
							System.out.println("The item(s) in your backpack are: ");
							//myInventory.listItems();
							System.out.println();
						}
						else {
							System.out.println("The item " + word[1] + " is not in the Container. Please try another item.");
						}
					}
					else {
						System.out.println("The container doesn't exist in this location.");
					}
					System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
				}
				break;
				
			}
			
			case "put": {
				//If there is an item with the given [name] in your character’s inventory, remove
				//it from the character’s inventory and add it to the specified [container] at the character’s current location. 
				
			if(word.length == 4 && word[2].equals("in")) {
					if(myInventory.presentItem(word[1])) {
						if(myLocation.containerPresent(word[3])) {
							myLocation.returnCon(word[3]).addItem(myLocation.returnCon(word[3]).itemReturn(word[1]));
							myLocation.returnCon(word[3]).remove(word[1]);
							System.out.println("The " + word[1] + " is added to the " + word[3]);
							System.out.println("The " + word[1] + " is now removed from your backpack. \n");
							System.out.println("The items remaining in your backpack are: ");
							myInventory.listItems();
							System.out.println();
						}
						else {
							System.out.println("The container you are trying to put doesn't exist. Please try another.");
						}
					}
					else {
							System.out.println("The item doesn't exist in your backpack. \n");
					}
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
					myLocation.addItem(myInventory.itemReturn(word[1]));
					myInventory.remove(word[1]);
					System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
				}
				
				break;
			}
			
			case "inventory": {
				if (word.length==1) {
					if(myInventory.itemsCount() == 0) {
						System.out.println(" There is no Item in your backpack \n");
					}
					else {
						myInventory.listItems();
						System.out.println();;
					}
				}
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

