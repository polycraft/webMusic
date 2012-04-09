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

	public void setRequest(HttpServletRequest request) {
			this.request = request;
			this.validators=new HashMap<String, ChainValidator>();
			form=new FormValidator();
			this.configure();
			this.associateValue();
			System.out.println("trest");
	}
	
	public boolean isInitialized() {
		return request!=null;
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
	
	public String getValue(String key) {
		return (String) validators.get(key).getValue();
	}
	
	public void setValue(String key,Object value) {
		validators.get(key).setValue(value);
	}
	
	public ChainValidator get(String key) {
		return validators.get(key);
	}
}
