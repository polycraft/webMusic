package test.util.validator;

import org.junit.Test;

import util.validator.LengthMaxValidator;

import junit.framework.TestCase;

public class LengthMaxValidatorTest extends SimpleValidatorTest {	
	
	@Test
	public void testLengthMaxValidator() {
		try
		{
			new LengthMaxValidator(5);
		} catch (IllegalArgumentException e) {fail("Aucune exception");}
		
		try
		{
			new LengthMaxValidator(0);
			fail("Valeur 0 interdite");
		} catch (IllegalArgumentException e) {}
		
		try
		{
			new LengthMaxValidator(-5);
			fail("Valeur négative interdite");
		} catch (IllegalArgumentException e) {}
	}

	@Test
	public void testValid() throws Exception {
		LengthMaxValidator validator=new LengthMaxValidator(5);
		assertFalse(validator.validate("dg sdg sdg "));
		assertTrue(validator.validate("Test"));
		assertTrue(validator.validate("juste"));
	}

}
