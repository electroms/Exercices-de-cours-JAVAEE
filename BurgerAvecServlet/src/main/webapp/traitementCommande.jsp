<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="entete.jsp"></jsp:include>
<h1>Récapitulatif de la commande</h1>

<%
// On récupère le tableau de burgers
	String[] burgers = (String[])request.getServletContext().getAttribute("burgers");
	String[] accompagnements = (String[])request.getServletContext().getAttribute("accompagnements");
	String[] boissons = (String[])request.getServletContext().getAttribute("boissons");
%>
<p>Burger commandé : <%=burgers[Integer.parseInt(request.getParameter("ID_BURGER"))] %></p>
<p>Accompagnement commandé : <%=accompagnements[Integer.parseInt(request.getParameter("ID_ACCOMPAGNEMENT"))] %></p>
<p>Boisson commandé : <%=boissons[Integer.parseInt(request.getParameter("ID_BOISSON"))] %></p>

</body>
</html>