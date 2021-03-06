<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%
// Declaration du tableau de burgers
String[] burgers = new String[4];

burgers[0] = "Domino Burger";
burgers[1] = "Burger Jambon";
burgers[2] = "BLT Burger";
burgers[3] = "Polenta Burger";
//On rend disponible a toutes les JSP le tableau de burgers
request.getServletContext().setAttribute("burgers", burgers);

// Declaration du tableau d'accompagnements
String[] accompagnements = new String[3];

accompagnements[0] = "Frites";
accompagnements[1] = "Salade";
accompagnements[2] = "Onion rings";
request.getServletContext().setAttribute("accompagnements", accompagnements);

// Declaration du tableau des boissons
String[] boissons = new String[2];

boissons[0] = "Badoit";
boissons[1] = "CLELIA Cola";

request.getServletContext().setAttribute("boissons", boissons);

// Declaration du tableau de sauces
String[] sauces = new String[2];

sauces[0] = "Ketchup";
sauces[1] = "Mayonnaise";
request.getServletContext().setAttribute("sauces", sauces);

// Déclaration des mois
String[] mois = new String[12];

mois[0] = "1";
mois[1] = "2";
mois[2] = "3";
mois[3] = "4";
mois[4] = "5";
mois[5] = "6";
mois[6] = "7";
mois[7] = "8";
mois[8] = "9";
mois[9] = "10";
mois[10] = "11";
mois[11] = "12";

request.getServletContext().setAttribute("mois", mois);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commande de restauration</title>
<link href="css/burger.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="entete.jsp"></jsp:include>
<h1>Commande de restauration rapide</h1>
<br>
<form action="traitementCommande.jsp" method="post">
<input type="radio" name="LIEU" value="1">Sur place
<input type="radio" name="LIEU" value="1">A emporter
<br><br>
<label>Votre Burger (4 &euro;)</label>
<select name="ID_BURGER">
<option value="-1">Aucun</option>
<% for (int i=0; i<burgers.length; i++) { %>
   <option value="<%=i%>">
       <%=burgers[i]%>
   </option>
<% } %>
</select>
<br><br>
<label>Votre accompagnement (2 &euro;)</label>
<select name="ID_ACCOMPAGNEMENT">
<option value="-1">Aucun</option>
<% for (int i=0; i<accompagnements.length; i++) { %>
   <option value="<%=i%>">
       <%=accompagnements[i]%>
   </option>
<% } %>
</select>
<br><br>
<label>Votre boisson (1 &euro;)</label>
<select name="ID_BOISSON" required>
<option value="-1">Aucune</option>
<% for (int i=0; i<boissons.length; i++) { %>
   <option value="<%=i%>">
       <%=boissons[i]%>
   </option>
<% } %>
</select>
<br><br>
<label>Remarques sur votre commande</label>
<textarea name="REMARQUES" rows="4" cols="40"></textarea>
<br>
<label>Sauce(s) (0.1 &euro;)</label>
<% for (int i=0; i<sauces.length; i++) { %>
   <input type="checkbox" name="SAUCE<%=i%>"> <%=sauces[i]%>
<% } %>
<br><br>
<label>Numéro de CB</label>
<textarea name="NUMERO CB" rows="1" cols="10"></textarea>
<br>
<br><br>

<label for="ID_MOIS">Mois</label>
        <select name="ID_MOIS">
            <%for(int i = 1; i < 13; i++){%>
                <option value="<% out.print(i);%>"><% out.print(i);%></option>
            <%}%>
            
        </select>
        <br>
        <br>
        <label for="ID_ANNEE">Année</label>
        <select name="ID_ANNEE">
        <% 
        int anneeEnCour = Calendar.getInstance().get(Calendar.YEAR);
        %>
            <%for(int i = 0; i < 4; i++){%>
                <option value="<% out.print(anneeEnCour + i);%>"><% out.print(anneeEnCour + i);%></option>
            <%}%>
        </select>
<br>
<br><br>
<label for="CRYPTOGRAMME">Cryptogramme</label>
<input type="text" id="crypto" name="CRYPTOGRAMME" maxlength="3">
<br>
<br><br>
<label>&nbsp;</label>
<input type="submit" value="Commander">
</form>
</body>
</html>
