<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Articles</title>
</head>
<body>



	
	<jsp:include page="entete.jsp"></jsp:include>
	





	<h1>Liste des Articles</h1>
	<br>
	<c:forEach items="${articles}" var="article">
		<h2>
			<a href="article?ID=${article.id}">${article.designation}</a>
			(${article.categorie.nom}) (nbPts: ${article.nbPoints}) (stock:
			${article.stock})
		</h2>
	</c:forEach>


	<br>
	<br>
	<p>Nombre total d'article(s): ${articles.size()}</p>
	<br>
	<br>
</body>
</html>
