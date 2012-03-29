package util.validator;

import util.validator.error.TooLongError;

public class LengthMaxValidator extends SimpleValidator<String> {
	private int max;
	
	public LengthMaxValidator(int max) {
		super();
		if(max<=0)
			throw new IllegalArgumentException("max must be positive");
		
		this.max = max;
	}

	public boolean valid() {		
		if(value.length()>max) {
			error=new TooLongError(max);
			return false;
		}
		return true;
	}
}
