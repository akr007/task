package teszt.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Kriszti�n
 *
 */
public class DBConnection {
	/**
	 * 
	 * Az adatb�zis �s az alkalmaz�s k�zti kapcsolatot �p�ti fel.
	 * A taskDB adatb�zist pr�b�lja meg el�rni a username �s a password megad�s�val.
	 * Ha ez siker�lt, akkor visszaadja a kapcsolatot.
	 * @return con
	 *
	 */
	public static Connection createConnection()
	 {
	     Connection con = null;
	     String db = "jdbc:mysql://localhost:3306/taskDB";
	     String name = "root"; 
	     String password = "root";
	     
	     try {
	         try {
	        	//Mysql driver bet�lt�se
	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } 
	         //Megpr�b�l csatlakozni az adatb�zishoz
	         con = DriverManager.getConnection(db, name, password);
	     } catch (Exception e) {
	        e.printStackTrace();
	     }
	     
	     return con; 
	 }
}
