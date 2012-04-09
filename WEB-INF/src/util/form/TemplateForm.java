package util.form;

public class TemplateForm {
	public static String value(Form form,String key) {
		String value=form.getRequestvalue(key);
		if(!form.get(key).hasError() && value!=null && !value.isEmpty()) {
			return "value=\""+value+"\"";
		}
		return "";
	}
	
	public static String valueTextarea(Form form,String key) {
		String value=form.getRequestvalue(key);
		if(!form.get(key).hasError()) {
			return value;
		}
		return "";
	}
	
	public static String selected(Form form,String key,Object value) {
		String valueTmp=form.getRequestvalue(key);
		
		if(!form.get(key).hasError() && valueTmp!=null && valueTmp.equals(value.toString())) {
			return "selected=\"selected\"";
		}
		return "";
	}
}
