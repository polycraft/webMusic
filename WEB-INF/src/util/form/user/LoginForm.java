package util.form.user;

import util.form.Form;
import util.validator.BlankValidator;
import util.validator.ChainValidator;

public class LoginForm extends Form {

	protected void configure() {
		add("username",new ChainValidator<String>().add(new BlankValidator()));
		add("password",new ChainValidator<String>().add(new BlankValidator()));
	}
}
