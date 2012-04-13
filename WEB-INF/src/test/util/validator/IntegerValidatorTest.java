package test.util.validator;

import org.junit.Test;

import util.validator.IntegerValidator;

public class IntegerValidatorTest extends SimpleValidatorTest {
	
	@Test
	public void testValid() throws Exception {
		IntegerValidator validator=new IntegerValidator();
		
		assertFalse(validator.validate("gfhhfg"));
		assertTrue(validator.validate("50"));
	}

}
