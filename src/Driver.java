import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static String myLocation;
	public static ArrayList<Item> myInventory= new ArrayList<Item>();

	public static void main(String[] args) {
		
		Item p = new Item("loc", "human", "lab partner");
		Item q = new Item("knife", "sharp", "Kill a person");
		Item r = new Item("chair", "wood", "To sit");
		Item s = new Item("broom", "weapon", "Sweep the floor");
		
		Location x = new Location("DePauw", "Sophomore");
		x.addItem(p);
		x.addItem(q);
		x.addItem(r);
		x.addItem(s);
		
		ContainerItem a = new ContainerItem("Cabinet", "kitchen", "Stores kitchen items");
		ContainerItem b = new ContainerItem("Vault", "Money keeper", "Keeps money");
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
			
			else if(word[0].equals("look")) {
				//If the command is “look”, print out the description of the location and just the names of each items found there
				
				System.out.println("The description of the location is: " + x.getDescription());
				System.out.println("The items in the class are: ");
				x.printNames();
				System.out.println();
			}
			
			else if(word[0].equals("examine")) {
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
			}
	
			else if(word[0].equals("take")) {
				if()
			}
			else {
				//If the command is something else
				System.out.println("I don't know how to do that. Please try another command listed above.\n");
			}
		}
		
	}
		
}

