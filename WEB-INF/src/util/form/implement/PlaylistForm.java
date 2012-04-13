package util.form.implement;

import model.Category;
import model.Language;
import model.Playlist;
import model.Record;
import model.User;

import org.hibernate.Session;

import util.form.Form;
import util.form.user.UserForm;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.IntegerValidator;
import util.validator.LengthMaxValidator;
import util.validator.SameValidator;

public class PlaylistForm extends Form {

	protected void configure() {
		add("name",new ChainValidator<String>().add(new BlankValidator())
				   .add(new LengthMaxValidator(10)));
	}
	
	public void fillRecord(Playlist playlist, Session session) {
		playlist.setName("name");
	}
	
	public void fillForm(Playlist playlist) {
		associateModel("name", playlist.getName());

	}

}
