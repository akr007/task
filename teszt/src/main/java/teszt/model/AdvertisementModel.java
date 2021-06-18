package teszt.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teszt.connection.DBConnection;
import teszt.data.Advertisement;

/**
 * A h�rdet�sek�rt felel�s model oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class AdvertisementModel {

	/**
	 * A h�rdet�sek �sszegy�jt�se egy list�ba.
	 * @return advs
	 */
	public List<Advertisement> getAllAdvertisement() {
		
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        //Egy Advertisement t�pus� lista
        List<Advertisement> advs = new ArrayList<Advertisement>();

        try{
        	//Fel�p�l egy kapcsolat az adatb�zissal
        	con = DBConnection.createConnection();
    		st = con.createStatement(); 
    		//Kiv�lasztunk minden adatot az advertisement t�bl�b�l
            rs = st.executeQuery("SELECT * FROM advertisement");
            
            while(rs.next()) {
            	//A kiv�lasztott adatokat elmentj�k
            	Advertisement adv = new Advertisement();
            	adv.setId(rs.getInt("id"));
            	adv.setTitle(rs.getString("title"));
            	adv.setDesc(rs.getString("description"));
            	//Felt�ltj�k az advs list�t
            	advs.add(adv);
            }
        } catch(SQLException e) {
               e.printStackTrace();
        }
        //Visszaadjuk a list�t
		return advs;
	}

}
