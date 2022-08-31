import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class SmartCardIdTest {

	@Test
	void testgetYear() {
		
		Date d1 = new Date();
		SmartCardId scid = new SmartCardId("Sam", "Mason", d1);
		
		assertEquals("2021", scid.getYear(d1));
	}
	
	@Test
	public final void testtoString() {
	
		Date d1 = new Date();
		SmartCardId scid = new SmartCardId("Sam", "Mason", d1);
 	   	
		assertTrue(scid.toString(), true);
	}
}
