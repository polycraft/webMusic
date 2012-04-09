package util.form.user;

import org.hibernate.Session;

import model.Language;
import model.User;

import util.form.Form;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.LengthMaxValidator;
import util.validator.SameValidator;

public class RegisterForm extends Form {

	protected void configure() {
		add("username",new ChainValidator<String>().add(new BlankValidator())
												   .add(new LengthMaxValidator(10)));
		add("password",new ChainValidator<String>().add(new BlankValidator())
												   .add(new LengthMaxValidator(20))
												   .add(new SameValidator(getRequestvalue("password2"))));
		add("emailAdress",new ChainValidator<String>().add(new BlankValidator())
												 	  .add(new LengthMaxValidator(20)));
		add("language",new ChainValidator<String>());
		add("firstname",new ChainValidator<String>());
		add("lastname",new ChainValidator<String>());
		add("biography",new ChainValidator<String>());
		add("picture",new ChainValidator<String>());
		add("website",new ChainValidator<String>());
		add("socialNetworkAccount",new ChainValidator<String>());
	}
	
	public void fillUser(User user, Session session) {
		user.setUsername(getRequestvalue("username"));
		user.setPassword(getRequestvalue("password"));
		user.setEmailAdress(getRequestvalue("emailAdress"));

		// Récupération de la classe Language
		user.setLanguage((Language) session.load(Language.class,
				new Integer(getRequestvalue("language"))));

		// Optionnel
		user.setFirstname(getRequestvalue("firstname"));
		user.setLastname(getRequestvalue("lastname"));
		user.setBiography(getRequestvalue("biography"));
		user.setPicture(getRequestvalue("picture"));
		user.setWebsite(getRequestvalue("website"));
		user.setSocialNetworkAccount(getRequestvalue("socialNetworkAccount"));
	}

}
