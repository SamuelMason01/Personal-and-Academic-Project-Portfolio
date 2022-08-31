
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;

class UniversityManagerTest {

	@Test
	void testregisterStudentone() {
		
		// create instance of Postgraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent pg1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		UniversityManager.registerStudent(pg1);
		
		assertEquals(1, UniversityManager.noOfStudents("UndergraduateStudent"));
		
	}
	
	@Test
	void testregisterStudenttwo() {
		
		// create instance of Postgraduate student (One)
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent pg1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		// create instance of Postgraduate student (Two)
		final StudentId sid2 = new StudentId();
		Date d2 = new Date();
		final SmartCard sc2 = new SmartCard("Dan", "Mason", d2);
		final ArrayList<Module> modules2 = new ArrayList<Module>();
						
		final AbstractStudent pg2 = new PostgraduateStudent(sid2, sc2, modules2);
		
		UniversityManager.registerStudent(pg1);
		UniversityManager.registerStudent(pg2);
		
		// list size is 3 because there was already one postgraduate student registered
		assertEquals(3, UniversityManager.noOfStudents("PostgraduateStudent"));
		
	}
	
	@Test
	void testremoveStudent() {
		
		// create instance of Postgraduate student (One)
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent pg1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		UniversityManager.registerStudent(pg1);
		UniversityManager.removeStudent(pg1.getStudentId());
		
		assertEquals(0, UniversityManager.noOfStudents("PostgraduateStudent"));
		
	}
	
	@Test
	void testnoOfStudents() {	
		
		// no Postgraduate students have been registered therefore the no of students should be 0
		
		assertEquals(0, UniversityManager.noOfStudents("PostgraduateStudent"));
		
	}
	
	@Test
	void testamendStudent() {	
		
		// create instance of Postgraduate student (One)
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
						
		final AbstractStudent pg1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		UniversityManager.registerStudent(pg1);
		
		// create new Postgraduate student details
		final SmartCard scnew = new SmartCard("Dan", "Chapman", d1);
		
		// create amended object
		final AbstractStudent amendedpg1 = pg1;
		
		// change details
		amendedpg1.setSmartCard(scnew);
		
		// amend student in list of students
		UniversityManager.amendStudent(pg1.getStudentId(), amendedpg1);
		
		// test confirms orginal smartcard details are not the same as those now stored (Therfore student
		// details have been amended.)
		assertNotEquals(sc1, amendedpg1.getSmartCard());

	}
	
	
	
	

}
