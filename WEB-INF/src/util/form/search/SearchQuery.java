package util.form.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Record;
import model.User;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;

public class SearchQuery {
	private Search search;

	public SearchQuery(Search search) {
		super();
		this.search = search;
	}
	
	public List<Record> createQuery(Session sessionHibernate, User user) {
		StringBuilder query=new StringBuilder();
		Map<String, Object> parameters=new HashMap<String, Object>();
		
		if(search.isAll()) {
			query.append("SELECT "+createSelectQuery()+" FROM Record WHERE 1");
			createWhereQuery(query,parameters,"all");
		}
		else {
			if(search.isPersonnal()) {
				haveUnion(query);
				query.append("SELECT "+createSelectQuery("r")+" ");
				query.append("FROM Copy c ");
				query.append("JOIN User u ON c.id_owner=u.id_user ");
				query.append("JOIN Record r ON c.id_record=r.id_record");
				query.append("WHERE 1");
				createWhereQuery(query,parameters,"personnal");
			}
			if(search.isTracked()) {
				haveUnion(query);
				query.append("SELECT "+createSelectQuery("r")+" ");
				query.append("FROM tracked_record c ");
				query.append("JOIN User u ON c.id_owner_flag=u.id_user ");
				query.append("JOIN Record r ON c.id_record=r.id_record");
				query.append("WHERE 1");
				createWhereQuery(query,parameters,"tracked");
			}
		}
		
		SQLQuery sqlQuery = sessionHibernate.createSQLQuery(query.toString());
		addParameters(sqlQuery, parameters);
		return (List<Record>) sqlQuery.addEntity(Record.class);
	}
	
	private void createWhereQuery(StringBuilder query,Map<String, Object> parameters,String prefix) {
		addCritereaLike("title",search.getText(), query, parameters, prefix);
		//addCritereaLike("title",search.getText(), query, parameters, prefix);
	}
	
	private String createSelectQuery() {
		return createSelectQuery("");
	}
	
	private String createSelectQuery(String prefix) {
		return prefix+".*";
	}
	
	private void addParameters(SQLQuery query,Map<String, Object> parameters) {
		for (Map.Entry<String, Object> e : parameters.entrySet()){
		    query.setParameter(e.getKey(), e.getValue());
		}
	}
	
	private void addCritereaLike(String field,String value,StringBuilder query,Map<String, Object> parameters,String prefix,String separator) {
		if(testCriterea(field)) {
			query.append(" "+separator+" "+field+" LIKE %:"+prefix+field+"%");
			parameters.put(prefix+field, value);
		}
	}
	
	private void addCritereaLike(String field,String value,StringBuilder query,Map<String, Object> parameters,String prefix) {
		addCritereaLike(field,value, query, parameters, prefix, "AND");
	}
	
	private boolean testCriterea(String criterea) {
		if(criterea==null)
			return false;
		else if(criterea.isEmpty())
			return false;
		return true;
	}
	
	private void haveUnion(StringBuilder query) {
		if(!query.toString().isEmpty()) {
			query.append(" UNION ");
		}
	}
}
