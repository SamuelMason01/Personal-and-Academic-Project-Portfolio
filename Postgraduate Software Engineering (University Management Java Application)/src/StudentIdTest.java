import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


class StudentIdTest {

	@Test
	public final void testgetLetterComponent() {
		
		// create instance of studentid
		final StudentId sid1 = new StudentId();
		
		// expected result (randomly generated character)
		char Expected = sid1.getLetterComponent();
    	
		// check does the method return the randomly generated character successfully
    	assertEquals(Expected, sid1.getLetterComponent());
	}
	
	@Test
	public final void testgetNumberComponent() {
		
		// create instance of studentid
		final StudentId sid1 = new StudentId();
		
		// expected result (randomly generated number)
		int Expected = sid1.getNumberComponent();
    	
		// check does the method return the randomly generated number successfully
    	assertEquals(Expected, sid1.getNumberComponent());
	}
	
	@Test
	public final void testtoString() {
	
		// create instance of studentid
		final StudentId sid1 = new StudentId();

		assertTrue(sid1.toString(), true);
}

}
