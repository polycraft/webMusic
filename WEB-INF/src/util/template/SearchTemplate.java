package util.template;

import util.form.search.Search;

public class SearchTemplate {
	public static String showOrderRecord(Search search,String column) {
		StringBuilder template=new StringBuilder();
		boolean up=false;
		boolean down=false;
		if(search.getOrder_col()!=null && search.getOrder()!=null) {
			up=search.getOrder_col().equals(column)&&search.getOrder().equals("up");
			down=search.getOrder_col().equals(column)&&search.getOrder().equals("down");
		}
		if(!up)
			template.append("<a href=\"?"+search.getAttributeGetOrder("up", column)+"\"><i class=\"icon-arrow-up\"></i></a>");
		if(!up&&!down)
			template.append("/");
		if(!down)
			template.append("<a href=\"?"+search.getAttributeGetOrder("down", column)+"\"><i class=\"icon-arrow-down\"></i></a>");
		
		return template.toString();
	}
	
	public static String showOrderTrack(Search search,String column) {
		StringBuilder template=new StringBuilder();
		boolean up=false;
		boolean down=false;
		if(search.getOrder_col_record()!=null && search.getOrder_record()!=null) {
			up=search.getOrder_col_record().equals(column)&&search.getOrder_record().equals("up");
			down=search.getOrder_col_record().equals(column)&&search.getOrder_record().equals("down");
		}
		if(!up)
			template.append("<a href=\"?"+search.getAttributeGetOrderRecord("up", column)+"\"><i class=\"icon-arrow-up\"></i></a>");
		if(!up&&!down)
			template.append("/");
		if(!down)
			template.append("<a href=\"?"+search.getAttributeGetOrderRecord("down", column)+"\"><i class=\"icon-arrow-down\"></i></a>");
		
		return template.toString();
	}
	
	private static boolean isActivateViews(Search search,String tab,boolean defaut) {
		return (search.getView()==null && defaut) || (search.getView()!=null && search.getView().equals(tab));
	}
	
	public static String activateViews(Search search,String tab,boolean defaut) {
		if(isActivateViews(search,tab,defaut))
			return "class=\"active\"";
		return "";
	}
	
	public static String linkViews(Search search,String tab,String text,boolean defaut) {
		if(!isActivateViews(search,tab,defaut))
			return "<a href=\"?"+search.getAttributeViewChange(tab)+"\">"+text+"</a>";
		return "<a>"+text+"</a>";
	}
}
