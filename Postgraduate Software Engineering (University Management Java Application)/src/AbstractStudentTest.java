import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AbstractStudentTest {

	@Test
	void testgetStudentId() {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		StudentId expected = ung1.getStudentId();
		
		assertEquals(expected, ung1.getStudentId());
				
	}
	
	@Test
	void testgetSmartCard() {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		SmartCard expected = ung1.getSmartCard();
		
		assertEquals(expected, ung1.getSmartCard());
				
	}
	
	@Test
	void testsetSmartCard() {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final SmartCard sc2 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		ung1.setSmartCard(sc2);
		
		assertEquals(sc2, ung1.getSmartCard());	
		
		
				
	}
	
	@Test
	void testreturnModule() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		ung1.registerModule("CSC8404");

		assertTrue(ung1.returnModule(), true);
				
	}
	
	@Test
	void testregisterModule() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		ung1.registerModule("CSC8404");

		assertEquals(1, ung1.getNoOfStudentsModules());
			
	}
	
	@Test
	void testregisterModuleThrowException() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
		final AbstractStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);

		// test successfully throw expetion when a postgraduate reserach student tries to register for modules
		
		Assertions.assertThrows(Exception.class, () -> {
			pgr1.registerModule("CSC8404");
			  });
	}
	
	@Test
	void testremoveModule() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		ung1.registerModule("CSC8404");
		ung1.removeModule("CSC8404");
		
		assertEquals(0, ung1.getNoOfStudentsModules());
			
	}
	
	@Test
	void testremoveModuleThrowException() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
		final AbstractStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);
		
		// test successfully throw expetion when a postgraduate reserach student tries to remove modules
		
		Assertions.assertThrows(Exception.class, () -> {
			pgr1.removeModule("CSC8404");
				});
			
	}
	
	@Test
	void testUndegraduatecheckModule() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent ung1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		ung1.registerModule("CSC8404");
		ung1.registerModule("CSC8406");
		ung1.registerModule("CSC8408");
		ung1.registerModule("CSC8410");
		ung1.registerModule("CSC8412");
		ung1.registerModule("CSC8414");
		
		assertEquals(true, ung1.checkModule());
			
	}
	
	@Test
	void testPostgraduatecheckModule() throws Exception {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent pg1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		pg1.registerModule("CSC8404");
		pg1.registerModule("CSC8406");
		pg1.registerModule("CSC8408");
		pg1.registerModule("CSC8410");
		pg1.registerModule("CSC8412");
		pg1.registerModule("CSC8414");
		pg1.registerModule("CSC8415");
		
		assertEquals(true, pg1.checkModule());
			
	}
	
	@Test
	void testPostgraduategetType() {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent pg1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		assertEquals("PostgraduateStudent", pg1.getType());
			
	}
	
	@Test
	void testUndergraduategetType() {

		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Dan", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
				
		final AbstractStudent pg1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		assertEquals("UndergraduateStudent", pg1.getType());
			
	}
	
	@Test
	public final void testtoString() {
	
	// create instance of  student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
	
		final AbstractStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);
 	   	
		assertTrue(pgr1.toString(), true);
}

}
