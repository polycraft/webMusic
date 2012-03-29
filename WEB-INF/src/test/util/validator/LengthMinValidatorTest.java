package test.util.validator;

import org.junit.Test;

import util.validator.LengthMinValidator;

import junit.framework.TestCase;

public class LengthMinValidatorTest extends SimpleValidatorTest {	
	
	@Test
	public void testLengthMinValidator() {
		try
		{
			new LengthMinValidator(5);
		} catch (IllegalArgumentException e) {fail("Aucune exception");}
		
		try
		{
			new LengthMinValidator(0);
			fail("Valeur 0 interdite");
		} catch (IllegalArgumentException e) {}
		
		try
		{
			new LengthMinValidator(-5);
			fail("Valeur négative interdite");
		} catch (IllegalArgumentException e) {}
	}

	@Test
	public void testValid() throws Exception {
		LengthMinValidator validator=new LengthMinValidator(5);
		assertTrue(validator.validate("dg sdg sdg "));
		assertTrue(validator.validate("juste"));
		assertFalse(validator.validate("Test"));		
	}

}
