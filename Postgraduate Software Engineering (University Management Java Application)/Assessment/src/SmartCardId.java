import java.util.Date;
import java.util.Random;

public class SmartCardId {
	
	/**
     * Variables
     */
	String smartcardnumber;
	
	Date dateofissue = new Date();
	Date dateofexpiry = new Date();
	
	private String firstname;
    private String surname;
    Date dateofbirth = new Date();
    
    SmartCardId(String firstname, String surname)
    {
    	this.smartcardnumber = firstname.substring(0, 1) + surname.substring(0, 1) + "-" + dateofissue+ "-" + new Random().nextInt(10 - 0 + 1) + 0;
    	this.firstname = firstname;
    	this.surname = surname;
    	this.dateofbirth = dateofbirth;
    }
    
    public String getName() {
    	return firstname + " " + surname;
    }
    
    public Date getExpiryDate() {
    	return dateofexpiry;
    }
    
    public Date setExpiryDate(Object ob) {
		return dateofexpiry;
    }
    
    public String toString() {
    	return smartcardnumber + " " + dateofissue;
    }
	

}
