import java.util.ArrayList;
import java.util.HashSet;

/** 
 * Undergraduate student - class.
 */

public final class UndergraduateStudent extends AbstractStudent {
	
	/**
	* Constructor
	*/
	public UndergraduateStudent(StudentId studentNumber, SmartCard smartcard, ArrayList<Module> modules) 
	{
		// To super class
        super(studentNumber, smartcard, modules);
    }
	
	/**
     * Method - Overide toString
     */
	public String toString()
	{
		return super.toString();
	}
}
