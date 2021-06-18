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
 * A hírdetések törléséért felelõs controller osztály.
 * @author Antal Krisztián
 *
 */
public class DeleteAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Alapértelmezett konstruktor. 
     */
    public DeleteAdvertisementServlet() {}

    /**
	 * A DeleteAdvertisementServlet doGet metódusa, amely törli a kiválasztott hírdetést.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view rétegbeli Home.jsp-ben szereplõ advId objektum lekérése
		int id = Integer.parseInt(request.getParameter("advId"));
		try {
			//Felépül egy kapcsolat az adatbázissal
			Connection con = DBConnection.createConnection();
			Statement st = con.createStatement();
			//Töröljük azokat a sorokat az adatbázisból,
			//ahol az id attribútum megegyezik a lekért id-vel
			st.executeUpdate("DELETE FROM advertisement WHERE id='"+id+"'");
			
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
	 * A DeleteAdvertisementServlet doPost metódusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
