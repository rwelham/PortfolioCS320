package Contact;

import java.util.ArrayList;

/**
 *
 * @author remywelham_snhu
 */
public class ContactService {
    // a list of Contacts that can be held, searched through, and edited 
    private ArrayList<Contact> contactList = new ArrayList<Contact>();
    
    // Creates a new contact and adds it to the list
    public void addContact(String ID, String firstName, String lastName, String number, String address){
        Contact contact = new Contact(ID, firstName, lastName, number, address);
        contactList.add(contact);
    }
    
    // allows a contact to be found
    public Contact getContact(String ID) throws Exception {
    	for(int i = 0; i < contactList.size(); i++){
            // if the contact at i matches, remove it and exit loop
            if(contactList.get(i).getID().equals(ID)){
                return contactList.get(i);
            }
        }
    	// no contact found in list so upon exit throw an exception
    	throw new Exception("Contact doesn't exist.");
    }
    
    // finds the contact from the ID given and then removes it from the list
    public void deleteContact(String contactID) throws Exception{
        contactList.remove(getContact(contactID));
    }
    
    // Updates the first name by finding the matching contact ID and setting the new first name at that id
    public void updateFirstName(String contactID, String newFirstName) throws Exception{
        getContact(contactID).setFirstName(newFirstName);
    }
    
    // Updates the last name by finding the matching contact ID and setting the new last name at that id
    public void updateLastName(String contactID, String newLastName) throws Exception{
        getContact(contactID).setLastName(newLastName);
    }
    
    // Updates the phone number by finding the matching contact ID and setting the new number at that ID
    public void updatePhoneNum(String contactID, String newNumber) throws Exception{
        getContact(contactID).setPhoneNum(newNumber);
    }
    
    // Updates the address by finding the matching contact ID and setting the new address at that ID
    public void updateAddress(String contactID, String newAddress) throws Exception{
         getContact(contactID).setAddress(newAddress);
    }
}
