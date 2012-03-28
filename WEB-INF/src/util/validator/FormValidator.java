package util.validator;

import java.util.List;

import util.validator.error.Error;

@SuppressWarnings("rawtypes")
public class FormValidator extends SimpleValidator<List<ChainValidator>>{
	
	public Error error;
	
	public boolean valid() {
		try {
			boolean hasError=false;
			
			for(ChainValidator validator:value) {
				if(!validator.validate())
					hasError=true;
			}
			
			return hasError;
		} catch (Exception e) {
			return false;
		}
	}
	
	public FormValidator add(ChainValidator validatorChain) {
		value.add(validatorChain);
		return this;
	}
}
