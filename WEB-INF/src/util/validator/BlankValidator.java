package util.validator;

import util.validator.error.BlankError;

public class BlankValidator extends SimpleValidator<String> {

	public boolean valid() {
		if(value.isEmpty()) {
			error=new BlankError();
			return false;
		}
		return true;
	}
	
}
