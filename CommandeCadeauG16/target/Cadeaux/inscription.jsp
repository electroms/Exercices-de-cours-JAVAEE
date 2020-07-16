<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!--  On ajoute une bibliotheque de balise nommée jstl pour java standard tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>
	<form action="inscription" method="post">
		<input type="text" name="NOM" placeHolder="Nom" /> <br />
		 <input type="text" name="PRENOM" placeHolder="Prénom" /> <br />
		 <input type="text" name="EMAIL" placeHolder="Email" /> <br />
  		 <input type="text" name="MOT_DE_PASSE" placeHolder="Mot de passe" /> <br/>
			<select name="ID_VILLE">
			
				<c:forEach items="${villes}" var="ville">
					<option value="${ville.id}">${ville.nom}</option>
				</c:forEach>
	
		</select> <br />
		<input type="submit" value="Inscription" />
	</form>
</body>
</html>