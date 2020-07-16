<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${article.designation}</title>
</head>
<body>
	
	<jsp:include page="entete.jsp"></jsp:include>

	<h1>${article.designation}</h1>
	<h2>${article.categorie.nom}</h2>
	<h3>nbPts: ${article.nbPoints}</h3>
	<h3>stock: ${article.stock}</h3>
	<h3>commandes passées: ${article.commandes.size()}</h3>
	<p>description: ${article.designation}</p>


	<form method="post" action="commande?ID=${article.id}">
		Quantité
		<input type="text" name="quantite">
		<input type="submit" value="Commander">
	</form>



</body>
</html>