import java.util.ArrayList;

/** 
 * Postgraduate student - class.
 */

public final class PostgraduateStudent extends AbstractStudent {
	
	/**
	* Constructor
	*/
	public PostgraduateStudent(StudentId studentNumber, SmartCard smartcard, ArrayList<Module> modules) 
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
