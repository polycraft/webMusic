package util.validator;

import util.validator.error.SameError;

public class SameValidator extends SimpleValidator<String> {
	private String value1;
	
	public SameValidator(String value1) {
		super();
		this.value1 = value1;
	}

	public boolean valid() {
		if(value.equals(value1)) {
			error=new SameError();
			return false;
		}
		return true;
	}
	
}
