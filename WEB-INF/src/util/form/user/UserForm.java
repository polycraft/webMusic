package util.form.user;

import model.Language;
import model.User;

import org.hibernate.Session;

import util.form.Form;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.LengthMaxValidator;

public abstract class UserForm extends Form {

	protected void configure() {
		add("username",new ChainValidator<String>().add(new BlankValidator())
												   .add(new LengthMaxValidator(10)));
		add("emailAdress",new ChainValidator<String>().add(new BlankValidator())
												 	  .add(new LengthMaxValidator(20)));
		add("language",new ChainValidator<String>());//TODO mettre un validateur
		add("firstname",new ChainValidator<String>());
		add("lastname",new ChainValidator<String>());
		add("biography",new ChainValidator<String>());
		add("picture",new ChainValidator<String>());
		add("website",new ChainValidator<String>());
		add("socialNetworkAccount",new ChainValidator<String>());
	}
	
	public void fillUser(User user, Session session) {
		user.setUsername(getRequestvalue("username"));
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
