package teszt.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import teszt.connection.DBConnection;
import teszt.data.User;

/**
 * A bejelentkez�s�rt felel�s model oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class LoginModel {
	
	/**
	 * Ellen�rzi, hogy a megadott adatok szerepelnek-e a user t�bl�ban.
	 * @param data A user adatb�zishoz tartoz� adatok
	 * @return Siker�lt vagy nem siker�lt a hiteles�t�s
	 */
     public String authenticateUser(User data) {
    	 
         Connection con = null;
         Statement st = null;
         ResultSet rs = null;
         
         //A data oszt�lyb�l kinyert adatok
         String email = data.getEmail();
	     String password = data.getPassword();
         String chosenEmail = "";
         String chosenPassword = "";
         
         try {
        	 //Fel�p�l egy kapcsolat az adatb�zissal
             con = DBConnection.createConnection(); 
             st = con.createStatement(); 
             //Kiv�lasztjuk az email �s a password adatokat a user t�bl�b�l
             rs = st.executeQuery("SELECT email, password FROM user");
 
             while(rs.next()) {
            	 //A kiv�lasztott adatokat elmentj�k
            	 chosenEmail = rs.getString("email");
            	 chosenPassword = rs.getString("password");
            	 //Ha a mez�k egyeznek akkor siker�lt a hiteles�t�s
		         if(email.equals(chosenEmail) && password.equals(chosenPassword)) {
		        	  return "OK"; 
		         }
             }
         } catch(SQLException e) {
                e.printStackTrace();
             }
         	//ellenben nem siker�lt a bejelentkez�s
            return "Rossz adatokat adt�l meg!"; 
         }
}