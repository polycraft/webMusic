package test.util.validator;

import org.junit.Test;

import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.LengthValidator;
import util.validator.error.BlankError;
import util.validator.error.TooShortError;

public class ChainValidatorTest extends ValidatorTest {
	ChainValidator<String> validator;
	
	protected void setUp() throws Exception {
		super.setUp();
		validator = new ChainValidator<String>().add(new BlankValidator()).add(new LengthValidator(3,5));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		validator = null;
	}

	@Test
	public void testValid() throws Exception {
		assertFalse(validator.validate(""));
		assertFalse(validator.validate("azyeze"));
		assertTrue(validator.validate("azeze"));
	}

	@Test
	public void testClearError() throws Exception {
		validator.validate("");
		assertTrue(validator.hasError());
		validator.clearError();
		assertFalse(validator.hasError());
	}

	@Test
	public void testHasError() throws Exception {
		validator.validate("");
		assertTrue(validator.hasError());
		
		validator.validate("a");
		assertTrue(validator.hasError());
		
		validator.validate("adf");
		assertFalse(validator.hasError());
	}

	@Test
	public void testGetErrors() throws Exception {
		validator.validate("");
		assertEquals(validator.getErrors().size(),2);
		
		validator.validate("a");
		assertEquals(validator.getErrors().size(),1);
	}

	@Test
	public void testGetError() throws Exception {
		validator.validate("");
		assertTrue(validator.getError() instanceof BlankError);
		validator.validate("a");
		assertTrue(validator.getError() instanceof TooShortError);
	}

	@Test
	public void testAdd() {
		assertEquals(validator.add(new BlankValidator()), validator);
	}

	@Test
	public void testSet() {
		validator.set("test");
		assertEquals("test", validator.getValue());
	}

}
