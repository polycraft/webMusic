package controller.importCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Record;
import model.Style;
import model.Track;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import au.com.bytecode.opencsv.CSVReader;



/**
 * @author sm23772
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ImportCSV extends HttpServlet {
	
	private Session sessionHibernate;
	private Transaction tx;
	private String relativePath = "C:/Program Files (x86)/Apache Software Foundation/Tomcat 7.0/webapps/webMusic";
	private String fileUploaded = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/importcsv/importcsv.jsp");
		dispatch.forward(request, response);		
		
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{

		
		//Si action Cancel :
		/*String action = (String) request.getAttribute("cancel");
		System.out.println(request.toString());
		if(action.equals("Cancel")){
			response.sendRedirect("");
		}*/
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println( "Upload" );
 
		
		// Create a new file upload handler
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory( );
 
		ServletFileUpload upload = new ServletFileUpload( fileItemFactory );
 
		// Set upload parameters
		int yourMaxMemorySize = 512 * 1024 * 8; // en bytes
		int yourMaxRequestSize = 1024 * 1024 * 8;
		String yourTempDirectory = this.relativePath+"/WEB-INF/tmp/"; // un r�pertoire ou tomcat
																											// a
		// le droit d'�crire
 
		fileItemFactory.setSizeThreshold( yourMaxMemorySize );
 
		// upload.setSizeThreshold(yourMaxMemorySize);
		upload.setSizeMax( yourMaxRequestSize );
		// upload.setRepositoryPath(yourTempDirectory);
 
		// Parse the request -on recup�re tous les champs du formulaire
		List items;
		try
		{
			items = upload.parseRequest(request);
 
			// Process the uploaded items
			Iterator iter = items.iterator( );
			while ( iter.hasNext( ) )
			{
 
				FileItem item = (FileItem) iter.next( );
 
				// Process a regular form field
				if ( item.isFormField( ) )
				{
					String name = item.getFieldName( );
					String value = item.getString( );
 
				}
				// Process a file upload
				else
				{
					String fieldName = item.getFieldName( );
					String fileName = item.getName( );
					String contentType = item.getContentType( );
					boolean isInMemory = item.isInMemory( );
					long sizeInBytes = item.getSize( );
 
					boolean writeToFile = true;
					// Copie directe pour les petits fichiers, sinon streaming (le
					// streaming ne marche pas)
					if ( sizeInBytes > 512 * 1024 * 8 ) writeToFile = false;
 
					// Process a file upload
					if ( ( writeToFile ) & ( fieldName.equals( "source" ) ) )
					{ // Ecriture directe
						System.out.println( "Ecriture directe" );
						//renomme avec la date
						Date actual = new Date(System.currentTimeMillis());
		             	DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		             	String date = dateFormat.format(actual);
		             	
						File uploadedFile = new File( yourTempDirectory + date +".csv" );
						item.write( uploadedFile );
						this.fileUploaded= yourTempDirectory + date+ ".csv";
					}
				}
			}
		}
		catch ( FileUploadException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace( );
		}
		
		/////////////////////////////////////////////////////
		// *************    TRAITEMENT CSV   **************//
		/////////////////////////////////////////////////////
		

	    
		if(this.fileUploaded != null){
			try {
				CSVReader csvReader = new CSVReader(new FileReader(this.fileUploaded),';');
				String [] nextLine;
			   
				
				while ((nextLine = csvReader.readNext()) != null) {
			    	//Creation de notre objet Session grace � notre HibernateUtil  
					sessionHibernate = HibernateUtil.currentSession();
					//Ouverture de notre transaction avec Hibernate grace
					// a la session 
			    	tx = sessionHibernate.beginTransaction();
					
				    if(nextLine[0].toString().equals("record")){
				    	//On regarde si le record existe d�ja ou non
				    	//connexion � la table est r�cuparation des resultats avec Title et matrix identique
				    	String title = nextLine[2].toString();
				    	String matrix = nextLine[4].toString();
						List<Record> doublonRecord=  (List<Record>) sessionHibernate.createQuery("from Record record where record.title = :title and record.matrix = :matrix").setParameter("title", title).setParameter("matrix",matrix).list();
						//on regarde si il y a des doublons
						if(doublonRecord.size()>=1){
							System.out.println("doublon");
						}
						else{
							//pas de doublons, on enregistre

					    	Record record = new Record();
					    	record.setIdRecord(null);
					    	
					    	model.Category category = (model.Category) sessionHibernate.get(model.Category.class, Integer.parseInt(nextLine[1].toString()));
					    	record.setCategory(category);
		
					    	record.setTitle(title);
					    	record.setWidth(Integer.parseInt(nextLine[3].toString()));
					    	record.setMatrix(matrix);
					    	record.setPressInfo(nextLine[5].toString());
					    	
					    	// On sauve, on renvoi, notre bean � la session Hibernate   
						     sessionHibernate.save(record);
						      
							// Nous commitons la transaction vers la base
						      tx.commit();

						}
						
				    }
				    if(nextLine[0].toString().equals("track")){
				    	//On regard si il existe le record �rent � la track
				    	//connexion � la table est r�cuparation des resultats avec Title et matrix de son record identique
				    	String matrix = nextLine[1].toString();				    	
				    	String title = nextLine[3].toString();				    	
						List<Record> record=  (List<Record>) sessionHibernate.createQuery("from Record record where record.matrix = :matrix").setParameter("matrix",matrix).list();
						//on regarde si le Record Parent existe d�ja dans la base de donn�e
						if(record.size()>=1){
							//Parent existant => ok pour l'enregistrement
							System.out.println("parent existe");
							
							//On regarde si la track existe d�ja ou non
							List<Track> doublonTrack=  (List<Track>) sessionHibernate.createQuery("from Track track where track.title = :titleTrack").setParameter("titleTrack",title).list();
							//List<Track> doublonTrack=  (List<Track>) sessionHibernate.createQuery("from Track").list();
							
							if(doublonTrack.size()>=1){
								//la track existe d�ja
								System.out.println("track existante");
								//Mais elle peut �tre ajout�e � un nouvel album
								//on regarde si elle appartient pas d�ja � l'album concern�
								Set<Track> tracks = record.get(0).getTracks();
								boolean alreadyExist = false;
								for(Track temp : tracks){
									if(temp.equals(doublonTrack.get(0))){
										System.out.println("d�ja dans le record");
										alreadyExist = true;
									}
								}
								
								if(!alreadyExist){
									//si track non dans record on ajoute
									System.out.println("track ajout� au nouveau record");
									Set<Track> tracks1 = record.get(0).getTracks();
									tracks1.add(doublonTrack.get(0));
									record.get(0).setTracks(tracks1);
									sessionHibernate.saveOrUpdate(record.get(0));
								     
									// Nous commitons la transaction vers la base
									tx.commit();
								}
								
							}
							else{
								System.out.println("track inexistante");
								//track inexistante => on l'ajoute
								Track track = new Track();
						    	track.setIdTrack(null);
						    	
						    	Style style = (Style) sessionHibernate.get(Style.class, Integer.parseInt(nextLine[2].toString()));
						    	track.setStyle(style);
						    	track.setTitle(title);
						    	track.setRythm(nextLine[4].toString());
						    	track.setLabel(Integer.parseInt(nextLine[5].toString()));
						    	track.setPlayingTime(Integer.parseInt(nextLine[6].toString()));
						    	
						    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						    	track.setReleaseDate(formatter.parse(nextLine[7].toString()));
						    	
						    	
						    	// On sauve, on renvoi, notre bean � la session Hibernate   
							     sessionHibernate.save(track);
							     
							   //on ajoute la track au record
							     Set<Track> tracks = record.get(0).getTracks();
							     tracks.add(track);
							     record.get(0).setTracks(tracks);
							      
							     sessionHibernate.saveOrUpdate(record.get(0));
							     
								// Nous commitons la transaction vers la base
							      tx.commit();
							      
							}
						}
						else{
							System.out.println("record parent inexistant");
						}
				    }
					//Enfin on ferme la session 
				      HibernateUtil.closeSession();
			    }
			
				csvReader.close();
				//On d�truit le fichier tempo
				File uploadedFile = new File( this.fileUploaded );
				uploadedFile.delete();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}
}

