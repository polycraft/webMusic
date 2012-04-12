package util.form.search;

import util.form.Form;
import util.validator.BlankValidator;
import util.validator.ChainValidator;

public class SearchForm extends Form {

	protected void configure() {
		add("text",new ChainValidator<String>());
		add("all",new ChainValidator<String>());
		add("personnal",new ChainValidator<String>());
		add("tracked",new ChainValidator<String>());
		add("order_col",new ChainValidator<String>());
		add("order",new ChainValidator<String>());
		add("view",new ChainValidator<String>());
		add("id_record",new ChainValidator<String>());
		add("id_track",new ChainValidator<String>());
	}
	
	public void fillSearch(Search search) {
		search.setText(getRequestvalue("text"));
		
		search.setAll(getRequestvalue("all")!=null);
		search.setPersonnal(getRequestvalue("personnal")!=null);
		search.setTracked(getRequestvalue("tracked")!=null);
		
		search.setOrder_col(getRequestvalue("order_col"));
		search.setOrder(getRequestvalue("order"));
		search.setView(getRequestvalue("view"));
		
		search.setId_record(new Integer(getRequestvalue("id_record")));
		search.setId_track(new Integer(getRequestvalue("id_track")));
	}
}