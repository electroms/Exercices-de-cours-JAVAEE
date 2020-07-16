<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merci!</title>
</head>
<body>



	<c:if test="${sessionScope.utilisateur eq null}">
		<p>Veuillez vous connecter pour effectuer une commande</p>
	</c:if>
	<c:if test="${sessionScope.utilisateur ne null}">
		<a href="deconnexion">Deconnexion</a>
		<br> Bonjour, ${sessionScope.utilisateur.prenom}
		<br>
		<a href="listeCommande">afficher mes commandes</a>
		<br>



		<br> Merci ${sessionScope.utilisateur.prenom} pour votre commande
		de ${commande.article.designation}, quantite: ${commande.quantite}

		<br>
	</c:if>






	<a href="Cadeau">Retour aux articles</a>

</body>
</html>