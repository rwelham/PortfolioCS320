package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Contact.ContactService;

/*
 * This is the JUnit test for Contact Services. The tests include:
 * 		Testing update first name
 * 		Testing update last name
 * 		Testing update phone number
 * 		Testing update address
 * 		Testing delete contact
 * 		Testing add contact
 */

class ContactServiceTest {


	ContactService service = new ContactService();
	
	@Test
	@DisplayName("Test GetContact")
	void testGetContact() {
		Assertions.assertThrows(Exception.class, ()->{
			service.getContact("0");
		});
	}
	
	
	@Test
	@DisplayName("Test contact add")
	void testAddContact() throws Exception {
		service.addContact("0", "Bill", "William", "3333333333", "123 Snow Hare Rd");
		assertAll("Groups Assertions for testing different parts of addContact",()->{
			Assertions.assertNotNull(service.getContact("0").getID());	
			Assertions.assertEquals("0", service.getContact("0").getID());
			Assertions.assertEquals("Bill", service.getContact("0").getFirstName());
			Assertions.assertEquals("3333333333", service.getContact("0").getPhoneNum());
		});
	}	
	
	
	@Test
	@DisplayName("Test contact delete")
	void testDeleteContact() throws Exception {
		ContactService service = new ContactService();
		service.addContact("1","Remy", "Ryan", "5555555551", "123 Snow Hare Rd");
		Assertions.assertThrows(Exception.class, ()->{
			service.deleteContact("1");
			service.getContact("1");
		});
	}
	
	
	@Test
	@DisplayName("Test for Update First Name")
	void testUpdateFirstName() throws Exception {
		ContactService service = new ContactService();
		service.addContact("00","Remy", "Ryan", "5555555551", "123 Snow Hare Rd");
		service.updateFirstName("00", "David");
		assertEquals("David", service.getContact("00").getFirstName(), "First Name has not been updated");
	}
	
	 
	@Test
	@DisplayName("Test for Update Last Name")
	void testUpdateLastName() throws Exception {
		ContactService service = new ContactService();
		service.addContact("2", "Remy", "Ryan", "5555555551", "123 Snow Hare Rd");
		service.updateLastName("2", "David");
		assertEquals("David", service.getContact("2").getLastName(), "Last Name has not been updated");
	}
	
	@Test
	@DisplayName("Test for Update Phone Number")
	void testUpdatePhoneNum() throws Exception {
		ContactService service = new ContactService();
		service.addContact("3","Remy", "Ryan", "5555555551", "123 Snow Hare Rd");
		service.updatePhoneNum("3", "1111111111");
		assertEquals("1111111111", service.getContact("3").getPhoneNum(), "Phone Number has not been updated");
	}
	
	@Test
	@DisplayName("Test for Update Address")
	void testUpdateAddress() throws Exception {
		ContactService service = new ContactService();
		service.addContact("4","Remy", "Ryan", "5555555551", "123 Snow Hare Rd");
		service.updateAddress("4", "123 Red Lion St");
		assertEquals("123 Red Lion St", service.getContact("4").getAddress(), "Address has not been updated");
	}

}
