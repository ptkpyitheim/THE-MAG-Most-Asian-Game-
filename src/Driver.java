import java.util.Scanner;

public class Driver {

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
		
		while(true) {
			System.out.print("Type a command: ");
			Scanner s1 = new Scanner(System.in);
			
			String userSentence = s1.nextLine();
			
			String word[] = userSentence.split(" ");
			
			
			if(word[0].equals("quit")) {
					break;
				}
			else if(word[0].equals("look")) {
				
				System.out.println("The description of the location is: " + x.getDescription());
				x.printNames();
				System.out.println();
			}
			
			else if(word[0].equals("examine")) {
				if(x.itemPresent(word[1])) {
					//System.out.println(word[1]);
					//System.out.println(x.getDescription());
				}
			}
			else {
				System.out.println("I don't know how to do that.");
				System.out.println();
			}
		}
		
	}
		
}

