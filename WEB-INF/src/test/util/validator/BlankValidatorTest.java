package test.util.validator;

import org.junit.Test;

import util.validator.BlankValidator;

public class BlankValidatorTest extends SimpleValidatorTest {
	
	@Test
	public void testValid() throws Exception {
		BlankValidator validator=new BlankValidator();
		
		assertFalse(validator.validate(""));
		assertTrue(validator.validate("Test"));
	}

}
