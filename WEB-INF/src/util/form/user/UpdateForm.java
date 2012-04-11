package util.form.user;

import model.User;

import org.hibernate.Session;

import util.validator.ChainValidator;
import util.validator.LengthMaxValidator;
import util.validator.SameValidator;

public class UpdateForm extends UserForm {

	protected void configure() {
		super.configure();
		add("password",new ChainValidator<String>().add(new LengthMaxValidator(20))
												   .add(new SameValidator(getRequestvalue("password_confirm"))));
		
		add("password_confirm",new ChainValidator<String>().add(new LengthMaxValidator(20)));
	}
	
	public void fillUser(User user, Session session) {
		super.fillUser(user,session);
		user.setPassword(getRequestvalue("password"));
	}

}
