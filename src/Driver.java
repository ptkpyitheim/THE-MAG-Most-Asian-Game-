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
		
		//System.out.println(x.itemPresent("loc"));
		//System.out.println(x.returnItem("chair"));
		//System.out.println(x.numItems());
		
		/*
		while(true) {
			System.out.print("Type a command: ");
			Scanner s = new Scanner(System.in);
			
			String userSentence = s.nextLine();
			
			String word[] = userSentence.split(" ");
			
			
			if(word[0].equals("quit")) {
				break;
			}
			else if(word[0].equals("look")) {
				
				System.out.println(x.getDescription());
				for(Item n: x.getCollections()) {
					System.out.println(n.getName());
				}
				System.out.println();
			}
			
			else if(word[0].equals("examine")) {
				for(Item n: x.getCollections()) {
					if(word[0].equals("examine") && word[1].equals(n.getName())) {
						System.out.println(n.getName());
						System.out.println(n.getDescription());
					}
				}
				}
			
			
			else {
				System.out.println("I don't know how to do that.");
				System.out.println();
			}
		}
		*/
	}
		
}

