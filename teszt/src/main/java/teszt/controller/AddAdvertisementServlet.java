package teszt.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import teszt.connection.DBConnection;
import teszt.data.Advertisement;
import teszt.model.AdvertisementModel;

/**
 * A hírdetések létrehozásáért felelõs controller osztály.
 * @author Antal Krisztián
 *
 */
public class AddAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * Alapértelmezett konstruktor. 
     */
    public AddAdvertisementServlet() {}
    
    /**
	 * Az AddAdvertisementServlet doGet metódusa, amely törli a kiválasztott hírdetést.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view rétegbeli CreatePage.jsp-ben szereplõ addAdv objektum lekérése
		Advertisement adv = (Advertisement) request.getAttribute("addAdv");
		
		try {
			//Felépül egy kapcsolat az adatbázissal
			Connection con = DBConnection.createConnection();
			Statement st = con.createStatement();
			//Beírjuk a táblába az új title és description adatokat
			String query = "INSERT INTO advertisement (title, description) "
						+ " VALUES ('"+adv.getTitle()+"','"+adv.getDesc()+"')";
			st.executeUpdate(query);
			
			//Lekérjük a jelenlegi session-t
			HttpSession session = request.getSession();
			AdvertisementModel advModel = new AdvertisementModel();
			//Lekérjük az összes hírdetést
			List<Advertisement> list = advModel.getAllAdvertisement(); 
			//Beállítjuk a következõ párt és a vezérlés átadódik a Home oldalra
			session.setAttribute("list", list);
			response.sendRedirect("Home.jsp");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Az AddAdvertisementServlet doPost metódusa, amely törli a kiválasztott hírdetést.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
