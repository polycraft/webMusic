package util.validator;

import util.validator.error.IntegerError;

public class IntegerValidator extends SimpleValidator<String> {

	public boolean valid() {
		
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			error=new IntegerError();
			return false;
		}
	}
	
}
