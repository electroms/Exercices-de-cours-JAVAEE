package fr.humanbooster.ph.autoroute.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnexionBdd {
 
     public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	 //On utilise le pilote JDBC de mysql
         Class.forName("com.mysql.jdbc.Driver");
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoroute?verifyServerCertificate=false&useSSL=true","root","");
         //System.out.println(connection);
         return connection ;
 }

	public static void close() {
		// TODO Auto-generated method stub
		
	}
}
