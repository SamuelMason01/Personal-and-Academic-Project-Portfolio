
/** 
 * Student - interface to students.
 */

public interface Student {
	
	// interfaced methods
	StudentId getStudentId();
	SmartCard getSmartCard();
	void setSmartCard(SmartCard smartcard);
	int getNoOfStudentsModules();
	String returnModule();
	Module registerModule(String code) throws Exception;
	Module removeModule(String code) throws Exception;
	boolean checkModule();
	String getType();
	
}
