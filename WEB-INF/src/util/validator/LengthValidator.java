package util.validator;

import util.validator.error.TooLongError;
import util.validator.error.TooShortError;

public class LengthValidator extends SimpleValidator<String> {
	private int min;
	private int max;
	
	public LengthValidator(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public boolean valid() {		
		int length=value.length();
		if(length<min) {
			error=new TooShortError(min);
			return false;
		}
		else if(length>max) {
			error=new TooLongError(max);
			return false;
		}
		return true;
	}
}
