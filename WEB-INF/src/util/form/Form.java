package util.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.validator.ChainValidator;
import util.validator.FormValidator;
import util.validator.error.Error;
import util.validator.error.Errorable;

public abstract class Form implements Errorable {
	private HttpServletRequest request;
	private Map<String, ChainValidator> validators;
	private FormValidator form;
	private List<Error> errors;
	
	protected abstract void configure();

	public void setRequest(HttpServletRequest request) {
			this.request = request;
			this.validators=new HashMap<String, ChainValidator>();
			form=new FormValidator();
			this.configure();
			this.associateValue();
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
		this.clearError();
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

	public void clearError() {
		this.errors = new ArrayList<Error>();
	}
	
	/*
	 * Retourne la présence d'erreur
	 */
	public boolean hasError() {
		if(errors==null)
			return false;
		return errors.size()!=0;
	}
	
	/*
	 * Retourne les erreurs
	 */
	public List<Error> getErrors() {
		return errors;
	}
	
	/*
	 * Retourne la première erreurs
	 */
	public Error getError() {
		if(hasError())
			return errors.get(0);
		return null;
	}
	
	public void addError(Error error) {
		errors.add(error);
	}
	
	
}
