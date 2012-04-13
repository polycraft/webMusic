package util.form.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Record;
import model.Track;
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
	
	public Object createQuery(Session sessionHibernate, User user) {
		StringBuilder query=new StringBuilder();
		Map<String, Object> parameters=new HashMap<String, Object>();
				
		if(search.getView().equals("record") && search.getId_record()!=null) {
			createQueryRecord(query,sessionHibernate,parameters);
			
			SQLQuery sqlQuery = sessionHibernate.createSQLQuery(query.toString()+addOrder(search.getOrder_col_record(),search.getOrder_record()));
			addParameters(sqlQuery, parameters);
			return sqlQuery.addEntity(Track.class).list();
		}
		else if(search.getView().equals("track") && search.getId_track()!=null) {
			return sessionHibernate.get(Track.class, search.getId_track());
		}
		else {
			int nbRequete=createQueryGeneral(query,sessionHibernate,user,parameters);
			String queryFinal;
			if(nbRequete==1) {
				queryFinal=query.toString()+addOrder(search.getOrder_col(),search.getOrder());
			}
			else {
				queryFinal="SELECT * FROM ("+query.toString()+") a "+addOrder(search.getOrder_col(),search.getOrder());
			}
			
			SQLQuery sqlQuery = sessionHibernate.createSQLQuery(queryFinal);
			addParameters(sqlQuery, parameters);
			return sqlQuery.addEntity(Record.class).list();
		}	
	}
	
	private int createQueryGeneral(StringBuilder query,Session sessionHibernate, User user,Map<String, Object> parameters) {
		int nbRequete=0;
		
		if(search.isAll() || user==null) {
			query.append("SELECT "+createSelectQuery()+" FROM record WHERE 1");
			createWhereQuery(query,parameters,"all");
			nbRequete++;
		}
		else if(user!=null){
			if(search.isPersonnal()) {
				haveUnion(query);
				query.append("SELECT "+createSelectQuery("r")+" ");
				query.append("FROM copy c ");
				query.append("JOIN user u ON c.id_owner=u.id_user ");
				query.append("JOIN record r ON c.id_record=r.id_record ");
				query.append("WHERE 1");
				createWhereQuery(query,parameters,"personnal");
				nbRequete++;
			}
			if(search.isTracked()) {
				haveUnion(query);
				query.append("SELECT "+createSelectQuery("r")+" ");
				query.append("FROM tracked_record c ");
				query.append("JOIN user u ON c.id_owner_flag=u.id_user ");
				query.append("JOIN record r ON c.id_record=r.id_record ");
				query.append("WHERE 1");
				createWhereQuery(query,parameters,"tracked");
				nbRequete++;
			}
		}
		return nbRequete;
	}
	
	private int createQueryRecord(StringBuilder query,Session sessionHibernate, Map<String, Object> parameters) {
		query.append("SELECT "+createSelectQuery("t")+" FROM track t JOIN link_record_track l ON t.id_track=l.id_track WHERE l.id_record=:id_record");
		parameters.put("id_record", search.getId_record());
		
		return 1;
	}
	
	private void createWhereQuery(StringBuilder query,Map<String, Object> parameters,String prefix) {
		addCritereaLike("title",search.getText(), query, parameters, prefix);
		addCritereaLike("artist",search.getArtist(), query, parameters, prefix);
		addCritereaLike("producer",search.getProducer(), query, parameters, prefix);
	}
	
	private String createSelectQuery() {
		return createSelectQuery("");
	}
	
	private String createSelectQuery(String prefix) {
		if(prefix.isEmpty())
			return "*";
		return prefix+".*";
	}
	
	private void addParameters(SQLQuery query,Map<String, Object> parameters) {
		for (Map.Entry<String, Object> e : parameters.entrySet()){
		    query.setParameter(e.getKey(), e.getValue());
		}
	}
	
	private void addCritereaLike(String field,String value,StringBuilder query,Map<String, Object> parameters,String prefix,String separator) {
		if(testCriterea(value)) {
			query.append(" "+separator+" "+field+" LIKE :"+prefix+field);
			parameters.put(prefix+field, "%"+value+"%");
		}
	}
	
	private void addCritereaLike(String field,String value,StringBuilder query,Map<String, Object> parameters,String prefix) {
		addCritereaLike(field,value, query, parameters, prefix, "AND");
	}
	
	private String addOrder(String order_col,String order) {
		StringBuilder orderQuery=new StringBuilder();
		if(order_col!=null && !order_col.isEmpty()) {
			orderQuery.append(" ORDER BY "+order_col);
			if(order!=null && !order.isEmpty()) {				
				if(order.equals("up"))
					orderQuery.append(" ASC");
				else
					orderQuery.append(" DESC");
			}
		}
		return orderQuery.toString();
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
