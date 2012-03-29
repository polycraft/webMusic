package util.validator;

import util.validator.error.TooShortError;

public class LengthMinValidator extends SimpleValidator<String> {
	private int min;
	
	public LengthMinValidator(int min) {
		super();
		if(min<=0)
			throw new IllegalArgumentException("min must be positive");
		
		this.min = min;
	}

	public boolean valid() {		
		if(value.length()<min) {
			error=new TooShortError(min);
			return false;
		}
		return true;
	}
}
