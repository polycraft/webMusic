package util.validator;

import util.validator.error.SameError;

public class SameValidator extends SimpleValidator<String> {
	private String compareValue;
	
	public SameValidator(String compareValue) {
		super();
		this.compareValue = compareValue;
	}
	
	public SameValidator() {
		super();
	}

	public boolean valid() {
		if(compareValue==null || !value.equals(compareValue)) {
			error=new SameError();
			return false;
		}
		return true;
	}

	public String getCompareValue() {
		return compareValue;
	}

	public void setCompareValue(String value) {
		this.compareValue = value;
	}
	
}
