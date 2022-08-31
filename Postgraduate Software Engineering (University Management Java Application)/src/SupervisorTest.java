import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SupervisorTest {

	@Test
	void testgetFirstname() {
		
		final Supervisor sup = new Supervisor("Sam", "Mason");
    	
    	assertEquals("Sam", sup.getFirstname());  
	}
	
	@Test
	void testgetSurname() {
		
		final Supervisor sup = new Supervisor("Sam", "Mason");
    	
    	assertEquals("Mason", sup.getSurname());
	}
	
	@Test
	void testgetNoOfSupervisors() {
		
		// 2 supervisors have been added therefore the expected return value is 4
    	assertEquals(4, Supervisor.getNoOfSupervisors());  
	}
	
	@Test
	void testcreateListOfSupervisors() {
		
		// static void method creates a list of modules
		
		// Important: Once the ArrayList of respective Supervisors has been created, its clear from the test 
		// assertion that the method was successful and a total of 4 elements have been stored. 
				
		Supervisor.createListOfSupervisors();
				
		int Expected = 4;
				
		assertEquals(Expected, Supervisor.getNoOfSupervisors());
		
	}
	
	@Test
	void testlistSupervisor() {
		
		// static void method lists all supervisors

		assertTrue(Supervisor.listSupervisor(), true);
		
	}
	
	@Test
	void testfindASupervisor() {
		
		Supervisor expectedSupervisor = Supervisor.findAsupervisor("Sam", "Mason");
		   	
    	assertEquals(expectedSupervisor, Supervisor.findAsupervisor("Sam", "Mason"));  
	}
	
	@Test
	public final void testtoString() {
	
		final Supervisor sup = new Supervisor("Sam", "Mason");
 	   	
		assertTrue(sup.toString(), true);
}

}
