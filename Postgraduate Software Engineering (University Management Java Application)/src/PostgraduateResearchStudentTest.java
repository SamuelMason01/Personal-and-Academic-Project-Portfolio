import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PostgraduateResearchStudentTest {

	@Test
	public final void testreturnSupervisor() {
		
		// create instance of postgraduate research student
			final StudentId sid1 = new StudentId();
			Date d1 = new Date();
			final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
			final ArrayList<Module> modules1 = new ArrayList<Module>();
			final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
				
			final PostgraduateResearchStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);
				
			assertEquals(null, pgr1.returnSupervisor());			
	}
	
	@Test
	public final void testregisterSupervisor() throws Exception {
		
		// create instance of postgraduate research student
			final StudentId sid1 = new StudentId();
			Date d1 = new Date();
			final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
			final ArrayList<Module> modules1 = new ArrayList<Module>();
			final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
				
			final PostgraduateResearchStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);
				
			pgr1.registerSupervisor("Sam", "Mason");
				
			assertEquals(1, supervisors1.size());			
	}
	
	@Test
	public final void testregisterSupervisorThrowException() throws Exception {
		
		// create instance of postgraduate research student
			final StudentId sid1 = new StudentId();
			Date d1 = new Date();
			final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
			final ArrayList<Module> modules1 = new ArrayList<Module>();
			final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
				
			final PostgraduateResearchStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);			
			
			// test successfully throw expetion when more than one supervisor is registered

			 Assertions.assertThrows(Exception.class, () -> {
				pgr1.registerSupervisor("Sam", "Mason");
				pgr1.registerSupervisor("Alex", "Smith");
				  });
		}		
	
	
		@Test
		public final void testtoString() {
		
		// create instance of undergraduate student
			final StudentId sid1 = new StudentId();
			Date d1 = new Date();
			final SmartCard sc1 = new SmartCard("Sam", "Mason", d1);
			final ArrayList<Module> modules1 = new ArrayList<Module>();
			final ArrayList<Supervisor> supervisors1 = new ArrayList<Supervisor>();
		
			final PostgraduateResearchStudent pgr1 = new PostgraduateResearchStudent(sid1, sc1, modules1, supervisors1);
     	   	
			assertTrue(pgr1.toString(), true);
	}

}
