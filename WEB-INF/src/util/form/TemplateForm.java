package util.form;

import util.validator.Validator;
import util.validator.error.Error;

public class TemplateForm {
	public static String value(Form form,String key) {
		String value=form.getValue(key);
		if(!form.get(key).hasError() && value!=null && !value.isEmpty()) {
			return "value=\""+value+"\"";
		}
		return "";
	}
	
	public static String valueTextarea(Form form,String key) {
		String value=form.getValue(key);
		if(!form.get(key).hasError() && value!=null && !value.isEmpty()) {
			return value;
		}
		return "";
	}
	
	public static String selected(Form form,String key,Object value) {
		String valueTmp=form.getValue(key);
		
		if(!form.get(key).hasError() && valueTmp!=null && valueTmp.equals(value.toString())) {
			return "selected=\"selected\"";
		}
		return "";
	}
	
	public static String globalError(Form form) {
		if(form.hasError()) {
			StringBuilder tmp=new StringBuilder();
			for(Error error:form.getErrors()) {
				tmp.append("<div class=\"alert alert-error\">"+error.toString()+"</div>");
			}
			return tmp.toString();
		}
		return "";
	}
	
	@SuppressWarnings("rawtypes")
	public static String fieldError(Validator validator) {
		if(validator.hasError())
			return "<span class=\"help-inline\">"+validator.getError().toString()+"</span>";
		return "";
	}
	
	@SuppressWarnings("rawtypes")
	public static String hasError(Validator validator) {
		if(validator.hasError())
			return " error";
			return "";
	}
}
