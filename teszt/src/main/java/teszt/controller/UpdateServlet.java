package teszt.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teszt.connection.DBConnection;
import teszt.data.Advertisement;

/**
 * A hirdetések frissítésre való kiválasztásáért felelõs controller osztály.
 * @author Antal Krisztián
 *
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alapértelmezett konstruktor
	 */
    public UpdateServlet() {}

    /**
	 * Az UpdateServlet doGet metódusa, amely kiválasztja az egyes hírdetéseket frissítésre.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view rétegbeli Home.jsp-ben szereplõ advId objektum lekérése
		int id = Integer.parseInt(request.getParameter("advId"));
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
        	//Felépül egy kapcsolat az adatbázissal
        	con = DBConnection.createConnection();
    		st = con.createStatement(); 
    		//Kiválasztjuk azokat a title és a description mezõket az advertisement táblából,
    		//ahol az id attribútum megegyezik a advId mezõvel
            rs = st.executeQuery("SELECT title, description FROM advertisement "
            		+ "WHERE id='"+id+"'");
            
            while(rs.next()) {
            	//A kiválasztott adatokat elmentjük
            	Advertisement adv = new Advertisement();
            	adv.setId(id);
            	adv.setTitle(rs.getString("title"));
            	adv.setDesc(rs.getString("description"));
            	//Beállítjuk a következõ párt és a vezérlés átadódik a Update oldalra
            	request.setAttribute("adv", adv);
            	request.getRequestDispatcher("/Update.jsp").forward(request, response);
            }
        } catch(SQLException e) {
            e.printStackTrace();
     }
	}
	
	/**
	 * Az UpdateServlet doPost metódusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
