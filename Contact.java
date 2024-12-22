package Contact;

/**
 *
 * @author remywelham_snhu
 */
public class Contact {
    // constructor variables
    private final String ID;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;
    
    public Contact(String ID, String firstName, String lastName, String phoneNum, String address){
    	if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Contact Id must not be null and must be 10 or fewer characters.");
		}
		else {
			this.ID = ID;
		}
        
        // firstName
        setFirstName(firstName);
        
        // lastName
        setLastName(lastName);
        
        //phone
        setPhoneNum(phoneNum);
        
        //address
        setAddress(address);
    }
    
    // getters
    public String getID(){ return ID;}
    
    public String getFirstName(){return firstName;}
    
    public String getLastName(){return lastName;}
    
    public String getPhoneNum(){return phoneNum;}
    
    public String getAddress() {return address;}
    
    // setters
    public void setFirstName(String firstName){
        if(firstName == null || firstName.length() > 10) {
        	throw new IllegalArgumentException("First name must not be null or longer than 10 characters.");
        }
        else {
        	this.firstName = firstName;
        }
    }
    
    public void setLastName(String lastName){
        if (lastName == null || lastName.length() > 10) {
        	throw new IllegalArgumentException("Last name must not be null or longer than 10 characters.");
        }
        else {
        	this.lastName = lastName;
        }
    }
    
    public void setPhoneNum(String phoneNum){
        if (phoneNum == null || phoneNum.length() != 10){
            throw new IllegalArgumentException("Phone number must be exactly 10 characters and not null");
        }
        else{
            this.phoneNum = phoneNum;
        }
    }
    
    public void setAddress(String address){
        if (address == null || address.length() > 30){
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters.");
        }
        else {
        	this.address = address;
        }
    }
}
