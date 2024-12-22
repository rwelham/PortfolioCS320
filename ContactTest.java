package Test;

import org.junit.jupiter.api.Test;
import Contact.Contact;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
/**
 *
 * @author remywelham
 * This will test the various conditions and actions for the Contact class. Tests include:
 * 	Contact ID is less than 10 characters
 * 	First Name is less than 10 characters
 * 	Last Name is less than 10 characters
 * 	Phone Number is exactly 10 characters
 * 	Address is less than 30 characters
 *  Contact ID is not null
 * 	First Name is not null
 * 	Last Name is not null
 * 	Phone Number is not null
 * 	Address is not null
 */
public class ContactTest{
	
	// contact made to be updated during the tests
	Contact testContact = new Contact("1", "2", "3", "0123456789", "5");
    
	@Test
	@DisplayName("Testing Constructor")
	public void testContactConstructor() {
		Contact testContact = new Contact("1", "2", "3", "0123456789", "5");
		assertAll("Asserts that all variables form correctly", ()->{
			Assertions.assertEquals("1", testContact.getID());
			Assertions.assertEquals("2", testContact.getFirstName());
			Assertions.assertEquals("3", testContact.getLastName());
			Assertions.assertEquals("0123456789", testContact.getPhoneNum());
			Assertions.assertEquals("5", testContact.getAddress());
		});
	}
	
	@Test
	@DisplayName("Contact ID cannot have more than 10 characters")
	void testContactIDForMoreThanTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("012345678910","FirstName","LastName","PhoneNumbr","Address");
		});
	}
	
	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters")
	void testFirstNameForMoreThanTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName11","LastName","PhoneNumbr","Address");
		});
	}
	
	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters")
	void testLastNameForMoreThanTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName","LastName111","PhoneNumbr","Address");
		});
	}
	
	@Test
	@DisplayName("Contact Phone Number must have 10 characters")
	void testPhoneNumberHasTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName","LastName","Phone","Address");
		});
	}
	
	@Test
	@DisplayName("Contact Address cannot have more than 30 characters")
	void testAddressForMoreThanThirtyCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName","LastName","PhoneNumbr","Address is too long so it will throw and exception here if done correctly");
		});
	}
	
	@Test
	@DisplayName("Contact ID cannot be null")
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact(null,"FirstName","LastName","PhoneNumbr","Address");
		});
	}
	
	@Test
	@DisplayName("Contact First Name cannot be null")
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0",null,"LastName","PhoneNumbr","Address");
		});
	}
	
	@Test
	@DisplayName("Contact Last Name cannot be null")
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName",null,"PhoneNumbr","Address");
		});
	}
	
	@Test
	@DisplayName("Contact Number cannot be null")
	void testPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName","LastName", null ,"Address");
		});
	}
	
	@Test
	@DisplayName("Contact Address cannot be null")
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{ 
			new Contact("0","FirstName","LastName","PhoneNumbr", null);
		});
	}

	@Test
	@DisplayName("Testing setting a new first name")
	void testSetFirstName() {
		testContact.setFirstName("name");
		assertTrue(testContact.getFirstName().equals("name"));
	}
	
	@Test
	@DisplayName("Testing setting a new last name")
	void testSetLastName() {
		testContact.setLastName("last");
		assertTrue(testContact.getLastName().equals("last"));
	}
	
	@Test
	@DisplayName("Testing setting a new phone number")
	void testSetPhoneNum() {
		testContact.setPhoneNum("5555555555");
		assertTrue(testContact.getPhoneNum().equals("5555555555"));
	}
	
	@Test
	@DisplayName("Testing setting a new address")
	void testSetAddress() {
		testContact.setAddress("address");
		assertTrue(testContact.getAddress().equals("address"));
	}
}
