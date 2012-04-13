package util.form.implement;

import model.Category;
import model.Language;
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

public class RecordForm extends Form {

	protected void configure() {
		add("title",new ChainValidator<String>().add(new BlankValidator())
				   .add(new LengthMaxValidator(10)));
		add("artist",new ChainValidator<String>().add(new LengthMaxValidator(20)));
		add("producer",new ChainValidator<String>().add(new LengthMaxValidator(20)));
		add("width",new ChainValidator<String>().add(new BlankValidator()).add(new IntegerValidator()));
		add("matrix",new ChainValidator<String>().add(new BlankValidator()));
		add("pressInfo",new ChainValidator<String>());
		add("category",new ChainValidator<String>());
	}
	
	public void fillRecord(Record record, Session session) {
		record.setTitle(getRequestvalue("title"));
		record.setArtist(getRequestvalue("artist"));
		record.setProducer(getRequestvalue("producer"));
		record.setWidth(Integer.parseInt(getRequestvalue("width")));
		record.setMatrix(getRequestvalue("matrix"));
		record.setPressInfo(getRequestvalue("pressInfo"));
		
		// Récupération de la Category
		record.setCategory((Category) session.load(Category.class, new Integer(getRequestvalue("category"))));
	}
	
	public void fillForm(Record record) {
		associateModel("title", record.getTitle());
		associateModel("artist", record.getArtist());
		associateModel("producer", record.getProducer());
		associateModel("width", ""+record.getWidth());
		associateModel("matrix", record.getMatrix());
		associateModel("pressInfo", record.getPressInfo());
		associateModel("category", record.getCategory().getIdCategory().toString());
	}

}
