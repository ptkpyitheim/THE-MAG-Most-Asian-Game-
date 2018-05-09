import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	public static Location myLocation = null; //to keep track of location
	public static ContainerItem myInventory = null; //to keep track of Inventory
	public static int points; //Points the character will have. If the charactor has zero points he/she loses.
	public static int MAX_ITEMS = 5; //Max items you can carry in your backpack.
 
	public static void main(String[] args) {

		myInventory = new ContainerItem("Backpack", "Yours", "Store your items", true);
		
		//Creating locations *********************
		Location Burma = new Location("Burma", "Start of the game", "What is the largest city of Myanmar(Burma)?", "Yangon", true);
		Location China = new Location("China", "North of Burma", "What is the captial city of China?", "Beijing", true);
		Location Thailand = new Location("Thailand", " ","What is the resort city in Thailand that is on the east coast of the Gulf of Thailand, about 100 kilometres south-east of Bangkok?", "Pattaya", true);
		Location Vietnam = new Location("Vietnam", " ", "What year did Vietnam War start?", "1955", false);
		Location India = new Location("India", " ", "What festival is also known as the 'festival of colours', a spring festival celebrated all across the Indian subcontinent?", "Holi", true);
		Location Laos = new Location("Laos", " ", "What is the major religion in Laos?", "Buddhism", true);
		Location Taiwan = new Location("Taiwan", " ", "What is the capital of Taiwan?", "Taipei", true);
		Location Philipines = new Location("Philipines", " ", "What is the currency of Phillipines?", "Peso", true);
		Location Malaysia = new Location("Malaysia", " ", "What is both a city and a country located in the southern tip of Peninsular Malaysia?", "Singapore", true);
		Location Pakistan = new Location("Pakistan", " ", "What is the year of partition of Indian and Pakistan?", "1947", true);
		Location America = new Location("America", " ", "What is American Independence Year?", "1776", true);
		
		//__________________________________________________________________________________________
		
		//Add connections to the location *********************
			//Adding connections for Burma
		Burma.addConnection("north", China);
		Burma.addConnection("south", Thailand);
		Burma.addConnection("east", Laos);
		Burma.addConnection("west", India);
		
			//Adding connections for China
		China.addConnection("south", Burma);
		China.addConnection("east", Laos);
		China.addConnection("west", India);
		
			//Adding connections for Thailand
		Thailand.addConnection("north", Burma);
		Thailand.addConnection("east", Laos);
		Thailand.addConnection("west", India);
		
			//Adding connections for Laos
		Laos.addConnection("north", China);
		Laos.addConnection("south", Thailand);
		Laos.addConnection("west", Burma);
		Laos.addConnection("east", Vietnam);
		
			//Adding connections for India
		India.addConnection("north", China);
		India.addConnection("south", Thailand);
		India.addConnection("east", Burma);
		India.addConnection("west", Pakistan);
		
			//Adding connections for Pakistan
		Pakistan.addConnection("east", India);
		
			//Adding connections for Vietnam
		Vietnam.addConnection("west", Laos);
		Vietnam.addConnection("east", Philipines);
		Vietnam.addConnection("north", Taiwan);
		Vietnam.addConnection("south", Malaysia);
		
			//Adding connections for Taiwan
		Taiwan.addConnection("south", Philipines);
		Taiwan.addConnection("east", America);
		Taiwan.addConnection("west", Vietnam);
		
			//Adding connections for Philipines
		Philipines.addConnection("north", Taiwan);
		Philipines.addConnection("south", Malaysia);
		Philipines.addConnection("east", America);
		Philipines.addConnection("west", Vietnam);
		
			//Adding connections for Malaysia
		Malaysia.addConnection("north", Philipines);
		Malaysia.addConnection("east", America);
		Malaysia.addConnection("west", Vietnam);
		
			//Adding connections for America
		America.addConnection("north", Taiwan);
		America.addConnection("south", Malaysia);
		America.addConnection("west", Philipines);
		
		//__________________________________________________________________________________________
		
		// Adding items and containerItem ***************
		//adding containerItem (trashCan)
		ContainerItem trashCan = new ContainerItem("TrashCan", "Can", "store trash food", true);
 		
		//adding items to Burma
		Item Mohinga = new Item("Mohinga", "Traditional noodles with fish based soup", "Breakfast", true);
		Burma.addItem(Mohinga);
		Burma.addItem(trashCan);
		
		//adding items to Vietnam
		Item Pho = new Item("Pho", "noodle soup", "Noodles with beef or chicken broth cooked in long time", true);
		Vietnam.addItem(Pho);
		Vietnam.addItem(trashCan);
		
		//adding items to China
		Item Dumplings = new Item("Dumplings", "Meat Ball", "taste better with sauce", false);
		China.addItem(Dumplings);
		China.addItem(trashCan);
		
		//adding items to India
		Item Biryani = new Item("Biryani", "Spicy Rice", "Made with spices, rice, and meat", true);
		India.addItem(Biryani);
		India.addItem(trashCan);
		
		//adding items to Pakistan
		Item Chapati = new Item("Chapati", "Unleavened flatbread", "cooked on a flat skiller", false);
		Pakistan.addItem(Chapati);
		Pakistan.addItem(trashCan);
		
		//adding items to Thailand
		Item PadThai = new Item("PadThai", "Stir fried rice noodle", "Street food in Thailand", true);
		Thailand.addItem(PadThai);
		Thailand.addItem(trashCan);
		
		//adding items to Laos
		Item Larb = new Item("Larb", "Lao meat salad", "unofficial national dish of Laos", true);
		Laos.addItem(Larb);
		Laos.addItem(trashCan);
		
		//adding items to Phillipines
		Item Sinigang = new Item("Sinigang", "Soup", "uSour and savoury taste", true);
		Philipines.addItem(Sinigang);
		Philipines.addItem(trashCan);
		
		//adding items to Malaysia
		Item NasiLemak = new Item("Nasi Lemak", "food", "Rice dish cooked in coconut milk and pandan leaf", true);
		Malaysia.addItem(NasiLemak);
		Malaysia.addItem(trashCan);
		
		//adding items to Taiwan
		Item BubbleTea = new Item("Bubble Tea", "drink", "tea with mixed with fruit or milk", true);
		Taiwan.addItem(BubbleTea);
		Taiwan.addItem(trashCan);
		
		//__________________________________________________________________________________________
		
		
		//******Game code******
		Scanner s1;
		System.out.println("***** Welcome to the MOST ASIAN GAME you'll ever play! *****\n");
		System.out.println("Welcome to the Golden Land, Myanmar(Burma)! From this destination, you will be exploring South East Asian countries.");
		System.out.println("In order to get to the final destination, you will need some specific items to get through each stage of the game.");
		System.out.println("In the command line below, try typing 'go north' to see what is there! \n");
		
		//initializing the world
		myLocation = Burma; //Character starts off at Burma
		points = 5; //Starts off with 5 points and lose one point for every one question answered incorrectly.
		
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
					System.out.println("The item(s) in " + myLocation.getName() + " are: ");
					myLocation.printNames();
					System.out.println("\nYou can type 'take' [name of the food] to put it in your backpack! You never know when it will be useful.");
					System.out.println("You can also type 'take' [name of the food] from [name of the container] (if present in the country) \n");
					if(myLocation.getName().equals("Thailand")){
						if(myInventory.presentItem("Dumplings")){
							Dumplings.setState(true);
						}
					}
					else if(myLocation.getName().equals("Burma")){
						if(myInventory.presentItem("Chapati")){
							Chapati.setState(true);
						}
					}
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
						n+= "\n" + "Type: " + myLocation.returnItem(word[1]).getType();
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
					else if(word[1].equals("TrashCan")) {
						System.out.println("You cannot add TrashCan to your backpack. TrashCan is used to throw away foods you don't want or if you have more than 5 food items in your backpack. \n You can access the TrashCan no matter which country you're at. \n  You can also grab food from the trashCan using the command 'take [name of the food] from TrashCan' \n");
					}
					else {
						System.out.println(myLocation.returnItem(word[1]));
						myInventory.addItem(myLocation.returnItem(word[1]));
						myLocation.removeItem(word[1]);
						System.out.println("The food " + word[1] + " is now in your backpack.");
						System.out.println("You have " + myInventory.itemsCount() + " item(s) in your backpack. \n");
						System.out.println("The food(s) in your backpack are: ");
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
							System.out.println("The food " + word[1] + " is now in your backpack.");
							System.out.println("The food(s) in your backpack are: ");
							myInventory.listItems();
							System.out.println();
						}
						else {
							System.out.println("The food " + word[1] + " is not in the Container. Please try another item.");
						}
					}
					else {
						System.out.println("The container doesn't exist in this location.");
					}
					System.out.println("You have " + myInventory.itemsCount() + " food(s) in your backpack. \n");
				}
				else {
					System.out.println("You have to type 'take [name of the food]' (or) 'take [name of the food] from trashCan'. Try again! \n");
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
							System.out.println("The container you are trying to put doesn't exist. Please try TrashCan. \n");
						}
					}
					else {
							System.out.println("The food doesn't exist in your backpack. \n");
					}
				}
			break;
			}
				
			
			case "drop": {
			//If there is an item with the given [name] in your character’s inventory, remove it from the
			//character’s inventory and add it to the Trashcan. 
				if(word.length==2) {
					if(!myInventory.presentItem(word[1])) {
						System.out.println("Food is not in your backpack." + "\n" + "Please try again below. \n");
					}
					else {
						trashCan.addItem(myInventory.itemReturn(word[1]));
						System.out.println("The food " + word[1] + " has been added to the Trash Can.\n If you wish, you can get it back from it later by using the command 'take [name of the food] from TrashCan'");
						System.out.println("Type 'examine TrashCan' to see what's in the Trash Can. \n");
						myInventory.remove(word[1]);
						System.out.println("You have " + myInventory.itemsCount() + " food(s) in your backpack. \nType 'inventory' to see what you have in your backpack.\n");
					}
				}
				else {
					System.out.println("Please type 'drop [name of food in your backpack]' \n");
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
				Scanner sc;
				String ans;
				int attempt = 0;
				if(word.length==2) {
					if(myLocation.goDirection(word[1]) != null) {
						if(myLocation.getName().equals("India")) {
							if(word[1].equals("west")) {
								if(myInventory.presentItem("Dumplings")) {
									if(Dumplings.getState()){
										myLocation = myLocation.goDirection(word[1]);
									}
									else{
										System.out.println("You need to set Dumplings to true(try go Thailand) to go to Pakistan");
									}
								}
								else {
									System.out.println("You need item: Dumplings to go to Pakistan");
								}
							}
							else{
								myLocation = myLocation.goDirection(word[1]);
							}
						}
						else if(myLocation.getName().equals("Laos")) {
							if(word[1].equals("east")) {
								if(myInventory.presentItem("Chapati")) {
									if(Chapati.getState()){
										myLocation = myLocation.goDirection(word[1]);
									}
									else{
										System.out.println("You need to set Chapati to true(Try go Pakistan) to go to Vietnam");
									}
								}
								else {
									System.out.println("You need item: Chapati to go to Vietnam");
								}
							}
							else{
								myLocation = myLocation.goDirection(word[1]);
							}
						}
						else if(myLocation.getName().equals("America")) {
							System.out.println("You have reached the final destination. YAYYYYY!!!");
							break;
						}
					
						else {
							myLocation = myLocation.goDirection(word[1]);
						}
						System.out.println("You are now in " + myLocation.getName() + " !!");
						System.out.println("	Please answer the question below in order to pass this country.");
						while(true) {
						System.out.println("		Question: " + myLocation.getQuestion());
						System.out.print("		Answer: ");
						sc = new Scanner(System.in);
						ans = sc.next();
						String answer[] = ans.split(" ");
							if(answer.length == 1) {
								if(ans.toLowerCase().equals(myLocation.getAnswer().toLowerCase())) {
									System.out.println("Your answer is correct! Type 'look' to see what signature foods " + myLocation.getName() + " has.");
									System.out.println("Or try going to another direction and explore more! \n");
									break;
								}
								else {
									attempt++;
									points--;
									if(points > 0) {
										System.out.println("\nYour answer is incorrect. You have attempted " + attempt + " time(s).");
										System.out.println("You got deducted a point. You have " + points + " point(s) remaining. REMEMBER: You lose if you have zero points left");
										System.out.println("Please try again below. \n");
									}
									else {
										System.out.println("\nI'm sorry. You have lost the game. You lost all your points.");
										System.out.println("Please type 'quit' below to end the game and restart again. \n");
										break;
									}
								}
							}
							
						else {
								System.out.println("Please give only one word answer.");
								break;
							}
						}
						break;
					}
					else {
						System.out.println("There is no where to go in that direction. Try another direction: north, south, east, or west. \n");
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
				System.out.println("I don't know how to do that. Please try another command listed above.\nRemember: Case sensitive words.\nYou can also type 'help' to see what commands are available.");
				break;
			}
			};
		}
		
		
	}
		
}

