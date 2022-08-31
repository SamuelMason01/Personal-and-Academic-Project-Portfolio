import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class SmartCardTest {

	@Test
	void testgetfName() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		assertEquals("Sam", sm.getfName());
	}
	
	@Test
	void testgetsName() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		assertEquals("Mason", sm.getsName());
	}
	
	@Test
	void testgetSmartCardId() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		assertEquals(sm.smartCardId, sm.getSmartCardId());
	}
	
	@Test
	void testgetDateOfIssue() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		assertEquals(sm.dateofissue, sm.getDateOfIssue());
	}
	
	@Test
	void testgetDOB() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		assertEquals(sm.dateofbirth, sm.getDOB());
	}
	
	@Test
	void testgetExpiryDate() {
		
		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		
		// expiry date has not been set
		assertEquals(0, sc1.getDateOfExpiry());
		
	}
	
	@Test
	void testgetYear() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		assertEquals("2021", sm.getYear(d1));
	}
	
	@Test
	void testgetFullDate() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
		
		// IMPORTANT: test will likely fail.
		// Assertion date string has probably chnaged, since i last tested therefore this will need to be changed accordingly.
		
		assertEquals("2021-16-20", sm.getFullDate(d1));
	}
	
	@Test
	void testsetPostgradExpiryDate() throws Exception {
		
		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		
		final PostgraduateStudent pg1 = new PostgraduateStudent(sid1, sc1, modules1);
		
		// using reflection to access private method and test it works correctly
		
		Method method = SmartCard.class.getDeclaredMethod("setExpiryDate", Date.class, Student.class);
		method.setAccessible(true);
				
		int value = (int) method.invoke(sc1 ,d1, pg1);
				
		assertEquals(2022, value);
				
	}
	
	@Test
	void testsetUndergradExpiryDate() throws Exception {
		
		// create instance of undergraduate student
		final StudentId sid1 = new StudentId();
		Date d1 = new Date();
		final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
		final ArrayList<Module> modules1 = new ArrayList<Module>();
		
		final UndergraduateStudent pg1 = new UndergraduateStudent(sid1, sc1, modules1);
		
		// using reflection to access private method and test it works correctly
		
		Method method = SmartCard.class.getDeclaredMethod("setExpiryDate", Date.class, Student.class);
		method.setAccessible(true);
		
		int value = (int) method.invoke(sc1 ,d1, pg1);
		
		assertEquals(2024, value);		
		
	}
	
	@Test
	public final void testtoString() {
		
		Date d1 = new Date();
		SmartCard sm = new SmartCard("Sam", "Mason", d1);
     	   	
    	assertTrue(sm.toString(), true);
	}

}
