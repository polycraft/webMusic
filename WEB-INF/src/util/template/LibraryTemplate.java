package util.template;

import java.util.List;
import java.util.Set;

import model.Copy;
import model.Record;
import model.Track;
import model.User;

public class LibraryTemplate {


	public static String displayEdit(User user ,Record record){
		
		if(user== null) return "";
		return "<a href=\"update_record?id="+record.getIdRecord()+"\" title=\"Update this record\"><i class=\"icon-edit\"></i></a>";
	}
	
	public static String displayFlag(User user ,Record record){
		
		if(user== null) return "";
		boolean alreadyTracked = false;
		for(Record temp : user.getRecords()){
			if(temp.equals(record)){
				alreadyTracked = true;
				break;
			}				
		}
		String edit=displayEdit(user,record);
		
		if(alreadyTracked){
			return "<a href=\"unflag_record?id="+record.getIdRecord()+"\" title=\"Unflag this record\"><i class=\"icon-star\"></i></a>"+edit;
		}
		else{
			return "<a href=\"flag_record?id="+record.getIdRecord()+"\" title=\"Flag this Record\"><i class=\"icon-flag\"></i></a>"+edit;
	
		}
	}
	
	public static String recordLink(Record record){
		return "<a href=\"record_details?id="+record.getIdRecord()+"\">"+record.getTitle()+"</a>";
	}
	
	public static String trackLink(Track track){
		return "<a href=\"track_details?id="+track.getIdTrack()+"\">"+track.getTitle()+"</a>";
	}
	
}
