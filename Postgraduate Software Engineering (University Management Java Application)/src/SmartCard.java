import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * Student Factory - interface to students.
 */

public class SmartCard {
	
	/**
     * Variables
     */
	Student student;
	String  smartCardId;
	private String firstname;
    private String surname;
    Date dateofbirth = new Date();
    Date dateofissue = new Date();
	private int dateofexpiry;
    
    /**
     * Constructor 
     */
    SmartCard(String firstname, String surname, Date dateofbirth)
    {
    	smartCardId= new SmartCardId(firstname, surname, dateofissue).toString();
    	this.firstname = firstname;
    	this.surname = surname;
    	this.dateofbirth = dateofbirth;
    	this.dateofexpiry = dateofexpiry;
    }
    
    /**
     * Method - get firstname
     */ 
    public String getfName() {
    	return firstname;
    }
    
    /**
     * Method - get surname
     */ 
    public String getsName() {
    	return surname;
    }
    
    /**
     * Method - get unique smartcardid
     */ 
    public String getSmartCardId() {
    	return smartCardId;
    }
    
    /**
     * Method - get date of issue
     */ 
    public Date getDateOfIssue() {
    	return dateofissue;
    }
    
    /**
     * Method - get date of expiry
     */ 
    public int getDateOfExpiry() {
    	return dateofexpiry;
    }
    
    /**
     * Method - get date
     */
    public Date getDOB() {
    	return dateofbirth;
    }
    
    /**
     * Method - get year (reformatted)
     */ 
    public String getYear(Date obj)
    {
    	SimpleDateFormat year = new SimpleDateFormat("yyyy");
    	return year.format(obj);
    }
    
    /**
     * Method - get full date (reformatted)
     */ 
    public String getFullDate(Date obj)
    {
    	SimpleDateFormat year = new SimpleDateFormat("yyyy-mm-dd");
    	return year.format(obj);
    }
    
    /**
     * Method - set expiry date)
     * @throws Exception 
     */ 
    private int setExpiryDate(Date obj, Student student) throws Exception
    {
    	if (student.getClass().getName().equals("PostgraduateResearchStudent"))
    	{
    		String s = new SimpleDateFormat("YYYY").format(obj);
    		dateofexpiry = Integer.parseInt(s)+5;
    		return dateofexpiry;
    	}
    	else if (student.getClass().getName().equals("PostgraduateStudent"))
    	{
    		String s = new SimpleDateFormat("YYYY").format(obj); 
    		dateofexpiry = Integer.parseInt(s)+1;
    		return dateofexpiry;
    	}
    	else if (student.getClass().getName().equals("UndergraduateStudent"))
    	{
    		String s = new SimpleDateFormat("YYYY").format(obj);
    		dateofexpiry = Integer.parseInt(s)+3;
    		return dateofexpiry;
    	}
    	else
    	{
    		throw new Exception("Unable to set date of expiry!");
    	}
    }
    
    /**
     * Method - Overide toString
     */  
    public String toString() {
    	return firstname + " " + surname + " " + dateofbirth + " " + smartCardId + " " + dateofexpiry;
    }

	

}
