import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


class ModuleTest {

	@Test
	void testgetCredits() {
		
		final Module mod = new Module("C1904", "Advanced Programming in Java", 20);
    	
    	assertEquals(20, mod.getCredits());  
	}
	
	@Test
	void testgetModName() {
		
		final Module mod = new Module("C1904", "Advanced Programming in Java", 20);
    	
    	assertEquals("Advanced Programming in Java", mod.getModName());  
	}
	
	@Test
	void testgetModCode() {
		
		final Module mod = new Module("C1904", "Advanced Programming in Java", 20);
    	
    	assertEquals("C1904", mod.getModCode());  
	}
	
	@Test
	void testgetNoOfModules() {
		
		// no modules have been added therefore the expected return value is 0
		
    	assertEquals(0, Module.getNoOfModules());  
	}
	
	@Test
	void testcreateListOfModules() {
		
		// static void method creates a list of modules
		
		// Important: Once the ArrayList of respective modules has been created, its clear from the test 
		// assertion that the method was successful and a total of 12 elements have been stored. 
		
		Module.createListOfModules();
		
		int Expected = 12;
		
		assertEquals(Expected, Module.getNoOfModules());
	}
	
	@Test
	void testlistModule() {
		
		// static void method lists all modules
		
		assertTrue(Module.listModule(), true);
		
	}
	
	@Test
	void testfindAModule() {
		
		Module expectedModule = Module.findAModule("CSC8407");
		
    	assertEquals(expectedModule, Module.findAModule("CSC8407"));  
	}
	
	@Test
	public final void testtoString() {
	
		final Module mod = new Module("C1904", "Advanced Programming in Java", 20);
 	   	
		assertTrue(mod.toString(), true);
}

}
