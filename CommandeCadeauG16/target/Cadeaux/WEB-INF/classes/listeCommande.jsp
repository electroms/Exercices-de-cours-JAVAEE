<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des commandes</title>
</head>
<body>








        <a href="deconnexion">Deconnexion</a>
        <br>
        Bonjour, ${sessionScope.utilisateur.prenom}!
        <br>
        



    <h1>Liste des Commandes</h1>
    <br>
		
		<c:forEach items="${commandes}" var="commande">
		<h2>
			${commande.article.designation} ${commande.article.categorie.nom} nbPts: ${commande.article.nbPoints}
			quantite: ${commande.quantite} <br>
        </h2>
		</c:forEach>
        

    <br>
    <br>
    <p>Nombre total de commandes: ${commandes.size()}</p>
    <br>
    <a href="Cadeau">Retour à l'index</a>

</body>
</html>