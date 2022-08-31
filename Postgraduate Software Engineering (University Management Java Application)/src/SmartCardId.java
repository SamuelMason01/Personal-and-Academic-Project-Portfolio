
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * SmartCardId - class.
 */

public class SmartCardId {

	/**
     * Variables
     */
	private String smartcardnumber;

	
	/**
     * Constructor 
     */
	SmartCardId(String fname, String sname, Date dateofissue) {
		this.smartcardnumber = fname.substring(0, 1) + sname .substring(0, 1) + "-"
				+ getYear(dateofissue) + "-" + (int) ((Math.random() * (99 - 01)) + 01);
	}
	
	/**
     * Method - get year
     */ 
	public String getYear(Date obj)
    {
    	SimpleDateFormat year = new SimpleDateFormat("yyyy");
    	return year.format(obj);
    }

	/**
     * Method - Overide toString
     */  
	public String toString() {
		return smartcardnumber;
	}

}
