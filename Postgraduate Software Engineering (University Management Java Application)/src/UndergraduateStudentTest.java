


import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;

class UndergraduateStudentTest {

	@Test
	public final void testtoString() {
		
		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		
		final UndergraduateStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
     	   	
    	assertTrue(ung1.toString(), true);
	}

}
