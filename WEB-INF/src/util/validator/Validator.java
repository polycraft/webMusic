package util.validator;

import util.validator.error.Errorable;

public abstract class Validator<T> implements Errorable{
	protected T value;
	
	protected abstract boolean valid();
	
	public boolean validate(T value) throws Exception {
		this.value=value;
		return this.validate();
	}
	
	public boolean validate() throws Exception {
		if(value==null)
			throw new Exception("Value not defined");
		this.clearError();
		return valid();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}