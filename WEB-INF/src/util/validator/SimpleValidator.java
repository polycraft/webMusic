package util.validator;

import util.validator.error.Error;

public abstract class SimpleValidator<T> extends Validator<T> {
	protected Error error;
	
	@Override
	public boolean hasError() {
		return error!=null;
	}

	@Override
	public Error getError() {
		return error;
	}
	
	public void clearError() {
		error=null;
	}
	
}
