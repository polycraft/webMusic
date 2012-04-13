package util.form.search;

import java.util.HashMap;
import java.util.Map;

public class Search {
	private String text;
	private String artist;
	private String producer;
	private boolean all;
	private boolean personnal;
	private boolean tracked;
	private String order_col;
	private String order;
	private String order_col_record;
	private String order_record;
	private String view;
	private Integer id_record;
	private Integer id_track;
	
	private HashMap<String,String> attributes;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		attributes=null;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
		attributes=null;
	}
	public boolean isPersonnal() {
		return personnal;
	}
	public void setPersonnal(boolean personnal) {
		this.personnal = personnal;
		attributes=null;
	}
	public boolean isTracked() {
		return tracked;
	}
	public void setTracked(boolean tracked) {
		this.tracked = tracked;
		attributes=null;
	}
	public String getOrder_col() {
		return order_col;
	}
	public void setOrder_col(String order_col) {
		this.order_col = order_col;
		attributes=null;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
		attributes=null;
	}
	public String getOrder_col_record() {
		return order_col_record;
	}
	public void setOrder_col_record(String order_col_record) {
		this.order_col_record = order_col_record;
	}
	public String getOrder_record() {
		return order_record;
	}
	public void setOrder_record(String order_record) {
		this.order_record = order_record;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
		attributes=null;
	}
	public Integer getId_record() {
		return id_record;
	}
	public void setId_record(Integer id_record) {
		this.id_record = id_record;
		attributes=null;
	}
	public Integer getId_track() {
		return id_track;
	}
	public void setId_track(Integer id_track) {
		this.id_track = id_track;
		attributes=null;
	}
	
	public String getAttributeGetOrder(String order,String column) {
		generatedMapAttributes();
		HashMap<String,String> attributes=(HashMap<String, String>) this.attributes.clone();
		attributes.put("order", order);
		attributes.put("order_col", column);
		
		return generatedAttribute(attributes);
	}
	
	public String getAttributeGetOrderRecord(String order,String column) {
		generatedMapAttributes();
		HashMap<String,String> attributes=(HashMap<String, String>) this.attributes.clone();
		attributes.put("order_record", order);
		attributes.put("order_col_record", column);
		
		return generatedAttribute(attributes);
	}
	
	public String getAttributeViewChange(String views)
	{
		generatedMapAttributes();
		HashMap<String,String> attributes=(HashMap<String, String>) this.attributes.clone();
		attributes.put("view", views);
		
		return generatedAttribute(attributes);
	}
	
	public String getAttributeViewNewRecord(Integer idRecord,String views)
	{
		generatedMapAttributes();
		HashMap<String,String> attributes=(HashMap<String, String>) this.attributes.clone();
		attributes.put("id_record", idRecord.toString());
		attributes.remove("id_track");
		attributes.put("view", views);
		
		return generatedAttribute(attributes);
	}
	
	public String getAttributeViewNewTrack(Integer idTrack,String views)
	{
		generatedMapAttributes();
		HashMap<String,String> attributes=(HashMap<String, String>) this.attributes.clone();
		attributes.put("id_track", idTrack.toString());
		attributes.put("view", views);
		
		return generatedAttribute(attributes);
	}
	
	public String getAttribute() {
		generatedMapAttributes();
		return generatedAttribute(attributes);
	}
	
	private String generatedAttribute(Map<String,String> attributes) {
		StringBuilder builder=new StringBuilder();
		String separator="";
		for (Map.Entry<String, String> e : attributes.entrySet()){
			if(!e.getValue().isEmpty()) {
				builder.append(separator);
				separator="&";
			    builder.append(e.getKey()+"="+e.getValue());
			}
		}
		
		return builder.toString();
	}
	
	private void generatedMapAttributes() {
		if(attributes==null)
		{
			attributes=new HashMap<String, String>();
			addMapAttribute(attributes,"text",text);
			addMapAttribute(attributes,"artist",artist);
			addMapAttribute(attributes,"order_col",order_col);
			addMapAttribute(attributes,"order",order);
			addMapAttribute(attributes,"order_col_record",order_col_record);
			addMapAttribute(attributes,"order_record",order_record);
			addMapAttribute(attributes,"view",view);
			addMapAttribute(attributes,"id_record",id_record);
			addMapAttribute(attributes,"id_track",id_track);
			
			if(all)
				attributes.put("all", "all");
			
			if(personnal)
				attributes.put("personnal", "personnal");
			
			if(tracked)
				attributes.put("tracked", "tracked");
		}
	}
	
	private void addMapAttribute(Map<String,String> map,String name,Object value) {
		if(value!=null && !value.toString().isEmpty() )
			map.put(name, value.toString());
	}
	
	public boolean isavancedSearch() {
		if((artist!=null && !artist.isEmpty()) || (producer!=null && !producer.isEmpty()))
			return true;
		return false;
	}
}
