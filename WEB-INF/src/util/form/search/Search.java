package util.form.search;

public class Search {
	private String text;
	private boolean all;
	private boolean personnal;
	private boolean tracked;
	private String order_col;
	private String order;
	private String view;
	private Integer id_record;
	private Integer id_track;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
	public boolean isPersonnal() {
		return personnal;
	}
	public void setPersonnal(boolean personnal) {
		this.personnal = personnal;
	}
	public boolean isTracked() {
		return tracked;
	}
	public void setTracked(boolean tracked) {
		this.tracked = tracked;
	}
	public String getOrder_col() {
		return order_col;
	}
	public void setOrder_col(String order_col) {
		this.order_col = order_col;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public Integer getId_record() {
		return id_record;
	}
	public void setId_record(Integer id_record) {
		this.id_record = id_record;
	}
	public Integer getId_track() {
		return id_track;
	}
	public void setId_track(Integer id_track) {
		this.id_track = id_track;
	}
	
}
