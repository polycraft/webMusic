package util.form.user;

import org.hibernate.Session;

import model.Language;
import model.User;

import util.form.Form;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.LengthMaxValidator;
import util.validator.SameValidator;

public class LoginForm extends Form {

	protected void configure() {
		add("username",new ChainValidator<String>().add(new BlankValidator()));
		add("password",new ChainValidator<String>().add(new BlankValidator()));
	}
}
