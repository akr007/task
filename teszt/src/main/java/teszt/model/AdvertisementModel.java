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
 * A hírdetésekért felelõs model osztály.
 * @author Antal Krisztián
 *
 */
public class AdvertisementModel {

	/**
	 * A hírdetések összegyûjtése egy listába.
	 * @return advs
	 */
	public List<Advertisement> getAllAdvertisement() {
		
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        //Egy Advertisement típusú lista
        List<Advertisement> advs = new ArrayList<Advertisement>();

        try{
        	//Felépül egy kapcsolat az adatbázissal
        	con = DBConnection.createConnection();
    		st = con.createStatement(); 
    		//Kiválasztunk minden adatot az advertisement táblából
            rs = st.executeQuery("SELECT * FROM advertisement");
            
            while(rs.next()) {
            	//A kiválasztott adatokat elmentjük
            	Advertisement adv = new Advertisement();
            	adv.setId(rs.getInt("id"));
            	adv.setTitle(rs.getString("title"));
            	adv.setDesc(rs.getString("description"));
            	//Feltöltjük az advs listát
            	advs.add(adv);
            }
        } catch(SQLException e) {
               e.printStackTrace();
        }
        //Visszaadjuk a listát
		return advs;
	}

}
