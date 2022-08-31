import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/** 
 * StudentId - class.
 */

public class StudentId {
	
	/**
	* Variables
	*/	
	private char LetterComponent;
	private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int NumberComponent;
	Random ran = new Random();

	/**
	* Constructor
	*/
	StudentId()
	{
		// Lettercomponent
		this.LetterComponent = abc.charAt(ran.nextInt(abc.length()));
		// Numbercomponent
		this.NumberComponent = (int) ((Math.random() * (9999 - 1000)) + 1000);
	}
	
	/**
     * Method - get letter
     */
	public char getLetterComponent() {return LetterComponent;}
	
	/**
     * Method - get number
     */
	public int getNumberComponent() {return LetterComponent;}
	
	/**
     * Method - Overide toString
     */  
	public String toString() {
		return""+ LetterComponent + NumberComponent;
	}
	
	
	
	
	
	
	
	
}
