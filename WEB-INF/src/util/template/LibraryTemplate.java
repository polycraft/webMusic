package util.template;

import java.util.List;
import java.util.Set;

import model.Copy;
import model.Record;
import model.User;

public class LibraryTemplate {


	public static String displayFlag(User user ,Record record){
		
		boolean alreadyTracked = false;
		for(Record temp : user.getRecords()){
			if(temp.equals(record)){
				alreadyTracked = true;
				break;
			}				
		}
		if(alreadyTracked){
			return "<a href=\"unflag_record?id="+record.getIdRecord()+"\" title=\"Unflag this record\"><i class=\"icon-star\"></i></a>";
		}
		else{
			return "<a href=\"flag_record?id="+record.getIdRecord()+"\" title=\"Flag this Record\"><i class=\"icon-flag\"></i></a>";
	
		}
	}
	
}
