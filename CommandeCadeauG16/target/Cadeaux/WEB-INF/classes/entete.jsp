<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<c:if test="${sessionScope.utilisateur eq null}">
		<a href="inscription">Inscription</a>
		<br>
		<a href="connexion">Connexion</a>
		<br>
	</c:if>
	<c:if test="${sessionScope.utilisateur ne null}">
		${sessionScope.utilisateur.prenom}
		<a href="deconnexion">Déconnexion</a>
		
		<br>
	</c:if>