package teszt.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Krisztián
 *
 */
public class DBConnection {
	/**
	 * 
	 * Az adatbázis és az alkalmazás közti kapcsolatot építi fel.
	 * A taskDB adatbázist próbálja meg elérni a username és a password megadásával.
	 * Ha ez sikerült, akkor visszaadja a kapcsolatot.
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
	        	//Mysql driver betöltése
	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } 
	         //Megpróbál csatlakozni az adatbázishoz
	         con = DriverManager.getConnection(db, name, password);
	     } catch (Exception e) {
	        e.printStackTrace();
	     }
	     
	     return con; 
	 }
}
