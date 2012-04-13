package util.form.search;

import util.form.Form;
import util.validator.BlankValidator;
import util.validator.ChainValidator;

public class SearchForm extends Form {

	protected void configure() {
		add("text",new ChainValidator<String>());
		add("artist",new ChainValidator<String>());
		add("all",new ChainValidator<String>());
		add("personnal",new ChainValidator<String>());
		add("tracked",new ChainValidator<String>());
		add("order_col",new ChainValidator<String>());
		add("order",new ChainValidator<String>());
		add("order_col_record",new ChainValidator<String>());
		add("order_record",new ChainValidator<String>());
		add("view",new ChainValidator<String>());
		add("id_record",new ChainValidator<String>());
		add("id_track",new ChainValidator<String>());
	}
	
	public void fillSearch(Search search) {
		search.setText(getRequestvalue("text"));
		search.setText(getRequestvalue("artist"));
		
		search.setAll(getRequestvalue("all")!=null);
		search.setPersonnal(getRequestvalue("personnal")!=null);
		search.setTracked(getRequestvalue("tracked")!=null);
		
		if(!search.isAll() && !search.isPersonnal() && !search.isTracked())
			search.setAll(true);
		
		search.setOrder_col(getRequestvalue("order_col"));
		search.setOrder(getRequestvalue("order"));
		
		search.setOrder_col_record(getRequestvalue("order_col_record"));
		search.setOrder_record(getRequestvalue("order_record"));
		
		if(getRequestvalue("view")!=null && !getRequestvalue("view").isEmpty())
			search.setView(getRequestvalue("view"));
		else
			search.setView("general");
		
		if(getRequestvalue("id_record")!=null)
			search.setId_record(new Integer(getRequestvalue("id_record")));
		
		if(getRequestvalue("id_track")!=null)
			search.setId_track(new Integer(getRequestvalue("id_track")));
	}
}