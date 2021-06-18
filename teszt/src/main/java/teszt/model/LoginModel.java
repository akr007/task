package teszt.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import teszt.connection.DBConnection;
import teszt.data.User;

/**
 * A bejelentkezésért felelõs model osztály.
 * @author Antal Krisztián
 *
 */
public class LoginModel {
	
	/**
	 * Ellenõrzi, hogy a megadott adatok szerepelnek-e a user táblában.
	 * @param data A user adatbázishoz tartozó adatok
	 * @return Sikerült vagy nem sikerült a hitelesítés
	 */
     public String authenticateUser(User data) {
    	 
         Connection con = null;
         Statement st = null;
         ResultSet rs = null;
         
         //A data osztályból kinyert adatok
         String email = data.getEmail();
	     String password = data.getPassword();
         String chosenEmail = "";
         String chosenPassword = "";
         
         try {
        	 //Felépül egy kapcsolat az adatbázissal
             con = DBConnection.createConnection(); 
             st = con.createStatement(); 
             //Kiválasztjuk az email és a password adatokat a user táblából
             rs = st.executeQuery("SELECT email, password FROM user");
 
             while(rs.next()) {
            	 //A kiválasztott adatokat elmentjük
            	 chosenEmail = rs.getString("email");
            	 chosenPassword = rs.getString("password");
            	 //Ha a mezõk egyeznek akkor sikerült a hitelesítés
		         if(email.equals(chosenEmail) && password.equals(chosenPassword)) {
		        	  return "OK"; 
		         }
             }
         } catch(SQLException e) {
                e.printStackTrace();
             }
         	//ellenben nem sikerült a bejelentkezés
            return "Rossz adatokat adtál meg!"; 
         }
}