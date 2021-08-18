package Section8;

import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;
	
	
	
	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		myContacts = new ArrayList<Contact>();
	}
	
	public boolean addNewContact(Contact newContact) {
		if (findContact(newContact.getName()) >= 0) {
			return false;
		}
		else {
			myContacts.add(newContact);
			return true;
		}
	}
	
	public boolean updateContact(Contact oldContact, Contact newContact) {
		if (myContacts.contains(oldContact)) {
			int position = myContacts.indexOf(oldContact);
			myContacts.set(position, newContact);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeContact(Contact contactToRemove) {
		if (myContacts.contains(contactToRemove)) {
			myContacts.remove(contactToRemove);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private int findContact(Contact contactToFind) {
		return myContacts.indexOf(contactToFind);
	}
	
	private int findContact(String name) {
		for (Contact contact : myContacts) {
			if (contact.getName().equals(name)) {
				return myContacts.indexOf(contact);
			}
		}
		return -1;
	}
	
	public Contact queryContact(String name) {
	for (Contact contact : myContacts) {
		if (contact.getName().equals(name)) {
			return contact;
		}
	}
	return null;
}
	
	public void printContacts() {
		System.out.println("Contact List: ");
		int i = 1;
		for (Contact contact : myContacts) {
			System.out.println(i + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
			i++;
		}
	}
}
