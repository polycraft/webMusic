package test.util.validator;

import org.junit.Test;

import util.validator.LengthMaxValidator;
import util.validator.LengthMinValidator;
import util.validator.LengthValidator;

public class LengthValidatorTest extends SimpleValidatorTest {	
	
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
	
	public void testLengthValidator() {
		try
		{
			new LengthValidator(3,5);
		} catch (IllegalArgumentException e) {fail("Aucune exception");}
		
		try
		{
			new LengthValidator(5,5);			
		} catch (IllegalArgumentException e) {fail("Aucune exception");}
		
		try
		{
			new LengthValidator(5,3);
			fail("min doit être plus petit que max");
		} catch (IllegalArgumentException e) {}
	}

	@Test
	public void testValid() throws Exception {
		LengthValidator validator=new LengthValidator(3,5);
		assertFalse(validator.validate("dg sdg sdg "));
		assertTrue(validator.validate("jus"));
		assertTrue(validator.validate("just"));
		assertTrue(validator.validate("juste"));
		assertFalse(validator.validate("Te"));		
	}

}
