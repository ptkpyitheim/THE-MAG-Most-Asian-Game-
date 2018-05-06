import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	public static Location myLocation = null; //to keep track of location
	public static ContainerItem myInventory = null; //to keep track of Inventory

	public static void main(String[] args) {

		myInventory = new ContainerItem("Backpack", "Yours", "Store your items");
		
		//Creating locations
		Location B = new Location("Burma", " ");
		Location C = new Location("China", " ");
		Location T = new Location("Thailand", " ");
		Location V = new Location("Vietnam", " ");
		Location I = new Location("India", " ");
		
		//Add connections to the location
			//Adding connections for Burma
		B.addConnection("north", C);
		B.addConnection("south", T);
		B.addConnection("east", V);
		B.addConnection("west", I);
		
			//Adding connections for China
		C.addConnection("south", B);
		C.addConnection("east", V);
		C.addConnection("west", I);
		
			//Adding connections for Thailand
		T.addConnection("north", B);
		T.addConnection("east", V);
		T.addConnection("west", I);
		
			//Adding connections for Vietnam
		V.addConnection("north", C);
		V.addConnection("south", T);
		V.addConnection("west", B);
		
			//Adding connections for India
		I.addConnection("north", C);
		I.addConnection("south", T);
		I.addConnection("east", B);
 		
		//adding items to Burma
		Item p = new Item("loc", "human", "lab partner");
		Item q = new Item("knife", "sharp", "Kill a person");
		Item r = new Item("chair", "wood", "To sit");
		Item s = new Item("broom", "weapon", "Sweep the floor");
		
		B.addItem(r);
		B.addItem(p);
		
		//creating ContainerItems in Burma and adding items.
		ContainerItem a = new ContainerItem("Cabinet", "Kitchen", "Place where you cook");
		ContainerItem b = new ContainerItem("Blah", "Box", "Store valuable things");
		a.addItem(q);
		a.addItem(s);
		
		//Adding containers to Burma.
		B.addItem(a);
		B.addItem(b);
		
		
		//adding items to Vietnam
		Item t = new Item("Oranges", "Vitamin C", "If you're sick.");
		Item t1 = new Item("Table", "Eat on it", "Wooden");
		
		ContainerItem r1 = new ContainerItem("Basket", "Store fruits", " ");
		ContainerItem r2 = new ContainerItem("Truck", "stores furniture", " ");
		V.addItem(t);
		V.addItem(t1);
		V.addItem(r1);
		V.addItem(r2);
		
		r1.addItem(t);
		r2.addItem(t1);
		
		
		//******Game code******
		Scanner s1;
		System.out.println("***** Welcome to the game! *****\n");
		System.out.println("Type 'help' to see what commands you can use for the game. \n Your are now in the Golden Land, Burma! \n");
		myLocation = B;
		
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
			case "help": {
				myLocation.getHelp();
				break;
			}

			case "look": {
				//If the command is “look”, print out the description of the location and just the names of each items found there
				if(word.length == 1) {
					System.out.println("The description of the location is: " + myLocation.getDescription());
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
				if(word.length==2) {
				if(!myLocation.itemPresent(word[1])) {
					System.out.println("Item is not in this location." + "\n" + "Please try again below. \n");
				}
				else {
					if(myLocation.containerPresent(word[1])) {
						System.out.println(myLocation.returnCon(word[1]).getDescription());
					}
					else {
						String n = "Name: " + myLocation.returnItem(word[1]).getName();
						n += "\n" + "Description: " + myLocation.returnItem(word[1]).getDescription() + "\n";
						System.out.println(n);
					}
				}
				break;
			}
				else {
					System.out.println("Please type 'examine' followed by the 'name' of the item. \n");
				}
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
							myInventory.addItem(myLocation.returnCon(word[3]).itemReturn(word[1]));
							myLocation.returnCon(word[3]).remove(word[1]);
							System.out.println("The item " + word[1] + " is now in your backpack.");
							System.out.println("The item(s) in your backpack are: ");
							myInventory.listItems();
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
							myInventory.remove(word[1]);
							System.out.println("The " + word[1] + " is added to the " + word[3]);
							System.out.println("The " + word[1] + " is now removed from your backpack. \n");
							System.out.println("The items remaining in your backpack are: ");
							myInventory.listItems();
							System.out.println();
						}
						else {
							System.out.println("The container you are trying to put doesn't exist. Please try another. \n");
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
				if(word.length==2) {
					if(!myInventory.presentItem(word[1])) {
						System.out.println("Item is not in this location." + "\n" + "Please try again below. \n");
					}
					else {
						myLocation.addItem(myInventory.itemReturn(word[1]));
						myInventory.remove(word[1]);
						System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
					}
				}
				else {
					System.out.println("Please type 'drop' followed by the name of an item in your backpack(inventory). \n");
				}
				
				
				break;
			}
			
			case "inventory": {
				if (word.length==1) {
					if(myInventory.itemsCount() == 0) {
						System.out.println(" There is no Items in your backpack \n");
					}
					else {
						myInventory.listItems();
						System.out.println();;
					}
				}
				break;
			}
			//word[1].equals("north") || word[1].equals("south") || word[1].equals("east") || word[1].equals("west")
			case "go" : {
				if(word.length==2) {
					if(myLocation.goDirection(word[1]) != null) {
						myLocation = myLocation.goDirection(word[1]);
						System.out.println("You are now in " + myLocation.getName() + " !! \n");
					}
					else {
						System.out.println("There is nothing where to go in that direction. Try another direction. \n");
					}
				}
				else {
					System.out.println("Invalid command \n Try again by typing go [direction]. \n");
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

