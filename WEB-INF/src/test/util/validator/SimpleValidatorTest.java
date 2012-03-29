package test.util.validator;

import org.junit.Test;

import util.validator.SimpleValidator;
import util.validator.error.BlankError;

public class SimpleValidatorTest extends ValidatorTest {
	private ImplementSimpleValidator validator;
	
   protected void setUp() throws Exception {
         super.setUp();
         validator = new ImplementSimpleValidator();
   }

   protected void tearDown() throws Exception {
         super.tearDown();
         validator = null;
   }
	
	@Test
	public void testHasError() throws Exception {
		
		validator.validate("test");
		assertFalse(validator.hasError());
		
		validator.validate("");
		assertTrue(validator.hasError());
	}

	@Test
	public void testGetError() throws Exception {
		validator.validate("test");
		assertTrue(validator.getError()==null);
		
		validator.validate("");
		assertTrue(validator.getError() instanceof BlankError);
	}

	@Test
	public void testClearError() throws Exception {
		validator.validate("");
		assertTrue(validator.hasError());
		validator.clearError();
		assertFalse(validator.hasError());
	}
}

class ImplementSimpleValidator extends SimpleValidator<String> {

	protected boolean valid() {
		if(value.isEmpty()) {
			error=new BlankError();
			return false;
		}
		return true;
	}
	
}
