<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Import CSV</title>
</head>
<body>
	<h1><p>Emettre un fichier (Upload)</p></h1>
      <form action="<%= request.getContextPath() + "/importcsv"%>" enctype="multipart/form-data" method="post">
         <p>Emission du fichier:<input type="file" name="source" size="30"></p>
 
         <p>
            <input type="submit" name="submitFichier" value="Annuler" title="Annuler l'émission">
            <input type="submit" name="submitFichier" value="Emettre" title="Emettre le fichier vers le serveur">
         </p>
      </form>
</body>
</html>