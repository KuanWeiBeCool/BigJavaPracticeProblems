package Section8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DemoLinkedList {
	
	public static void main(String[] args) {
		LinkedList<String> placeToVisit = new LinkedList<String>();
//		placeToVisit.add("Montreal");
//		placeToVisit.add("Toronto");
//		placeToVisit.add("Ottawa");
//		placeToVisit.add("UPenn");
//		
//		printList(placeToVisit);
//		
//		placeToVisit.add(1, "MIT"); // Add "MIT" to index 1
//		
//		printList(placeToVisit);
//		
//		placeToVisit.remove(4);
//		placeToVisit.remove("Ottawa");
//		
//		printList(placeToVisit);		
		
		addInOrder(placeToVisit, "Ababa");
		addInOrder(placeToVisit, "Sahara");
		addInOrder(placeToVisit, "Kakaka");
		addInOrder(placeToVisit, "Adada");
		addInOrder(placeToVisit, "AA");
		addInOrder(placeToVisit, "Hakulamakaka");
		addInOrder(placeToVisit, "Omega");
		printList(placeToVisit);
	}

	private static void printList(LinkedList<String> ls) {
		Iterator<String> i = ls.iterator();
		while (i.hasNext()) {
			System.out.println("To visit: " + i.next());
		}
		System.out.println("==================");
	}
	
	private static boolean addInOrder(LinkedList<String> ls, String newCity) {
		ListIterator<String>iterator = ls.listIterator();
		while (iterator.hasNext()) {
			String currCity = iterator.next();
			if (currCity.compareTo(newCity) == 0) {
				// Name already exists
				return false;
			}
			else if (currCity.compareTo(newCity) > 0){
				// Name should be placed right before currCity
				// Need to go back one step.
				iterator.previous();
				iterator.add(newCity);
				return true;
			}
			else if (currCity.compareTo(newCity) < 0) {
				// Move on
				continue;
			}
		}
		// After the while loop, hasn't added the name yet. Meaning it should be the last one.
		iterator.add(newCity);
		return true;
		
	}
}
