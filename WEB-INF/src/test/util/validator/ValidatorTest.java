package test.util.validator;

import junit.framework.TestCase;

import org.junit.Test;

import util.validator.Validator;
import util.validator.error.Error;

public class ValidatorTest extends TestCase {
	private ImplementValidator validator;
	
   protected void setUp() throws Exception {
         super.setUp();
         validator = new ImplementValidator();
   }

   protected void tearDown() throws Exception {
         super.tearDown();
         validator = null;
   }
	
	@Test
	public void testValidate() throws Exception {
		
		assertTrue(validator.validate("test"));
		assertTrue(validator.getValue()=="test");
		assertFalse(validator.validate(""));
		
		validator.setValue("test");
		assertTrue(validator.validate());
		assertTrue(validator.getValue()=="test");
		
		validator.setValue("");
		assertFalse(validator.validate());
		
		try {
			validator.validate(null);
			fail("Exception attendu");
		}
		catch (Exception e) {}
	}

	@Test
	public void testValue() {
		validator.setValue("blabla");
		assertTrue("blabla".equals(validator.getValue()));
	}
}

class ImplementValidator extends Validator<String> {

	protected boolean valid() {
		if(value.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasError() {
		return false;
	}

	public Error getError() {
		return null;
	}

	public void clearError() {		
	}
	
}
