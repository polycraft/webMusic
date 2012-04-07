package test.util.validator;

import org.junit.Test;

import util.validator.SameValidator;

public class SameValidatorTest extends SimpleValidatorTest {
	
	@Test
	public void testValid() throws Exception {
		SameValidator validator=new SameValidator("Test");
		
		assertFalse(validator.validate("Test1"));
		assertFalse(validator.validate("test"));
		assertTrue(validator.validate("Test"));
	}
}
