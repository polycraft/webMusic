package test.util.validator;

import org.junit.Test;

import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.FormValidator;
import util.validator.LengthMaxValidator;
import util.validator.LengthMinValidator;
import util.validator.error.BlankError;
import util.validator.error.TooLongError;

public class FormValidatorTest extends SimpleValidatorTest {
	@Test
	public void testValid() throws Exception {
		FormValidator validator=new FormValidator();		
		ChainValidator<String> chain1=new ChainValidator<String>().add(new BlankValidator())
																  .add(new LengthMaxValidator(5));
		ChainValidator<String> chain2=new ChainValidator<String>().add(new BlankValidator())
				  												  .add(new LengthMinValidator(3));
		validator.add(chain1).add(chain2);
		
		chain1.set("test");
		chain2.set("test");
		assertTrue(validator.validate());
		assertFalse(chain1.hasError());
		assertFalse(chain2.hasError());
		
		chain1.set("test test");
		assertFalse(validator.validate());
		assertTrue(chain1.hasError());
		assertTrue(chain1.getError() instanceof TooLongError);
		assertFalse(chain2.hasError());
		
		chain2.set("");
		assertFalse(validator.validate());
		assertTrue(chain1.hasError());
		assertTrue(chain1.getError() instanceof TooLongError);
		assertTrue(chain2.hasError());
		assertTrue(chain2.getError() instanceof BlankError);
		
		chain1.set("test");
		assertFalse(validator.validate());
		assertFalse(chain1.hasError());
		assertTrue(chain2.hasError());
		assertTrue(chain2.getError() instanceof BlankError);
	}

	@Test
	public void testAdd() {
		FormValidator validator=new FormValidator();
		assertEquals(validator.add(new ChainValidator<String>()), validator);
	}

}
