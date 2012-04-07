package util.validator;

import java.util.ArrayList;
import java.util.List;

import util.validator.error.Error;

@SuppressWarnings("rawtypes")
public class FormValidator extends SimpleValidator<List<ChainValidator>> {

	public Error error;

	public FormValidator() {
		value = new ArrayList<ChainValidator>();
	}

	public boolean valid() {
		boolean isValid = true;

		for (ChainValidator validator : value) {
			if (!validator.validate())
				isValid = false;
		}

		return isValid;
	}

	public FormValidator add(ChainValidator validatorChain) {
		value.add(validatorChain);
		return this;
	}
}
