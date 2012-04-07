package util.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.validator.ChainValidator;
import util.validator.FormValidator;

public abstract class Form {
	private HttpServletRequest request;
	private Map<String, ChainValidator> validators;
	private FormValidator form;
	
	protected abstract void configure();
	
	public Form(HttpServletRequest request) {
		super();
		this.request = request;
		this.validators=new HashMap<String, ChainValidator>();
		form=new FormValidator();
		this.configure();
		this.associateValue();
	}

	protected void add(String name,ChainValidator validator) {
		validators.put(name, validator);
		form.add(validator);
	}
	
	protected void remove(String name) {
		validators.remove(name);
	}
	
	public String getRequestvalue(String value) {
		return request.getParameter(value);
	}
	
	public boolean validate() {
		return form.validate();
	}
	
	private void associateValue() {
		String value;
		for (String key : validators.keySet()) {
			value=request.getParameter(key);
			if(value!=null) {
				validators.get(key).set(value);
			}
		}
	}
}
