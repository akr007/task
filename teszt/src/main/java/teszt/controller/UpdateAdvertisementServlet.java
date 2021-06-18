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
 * 
 * A hirdetések frissítését elvégzõ controller osztály.
 * @author Antal Krisztián
 *
 */
public class UpdateAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Alapértelmezett konstruktor. 
     */
    public UpdateAdvertisementServlet() {}

    /**
	 * Az UpdateAdvertisementServlet doGet metódusa, amely frissíti az egyes hírdetéseket.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view rétegbeli UpdatePage.jsp-ben szereplõ updateAdv objektum lekérése
		Advertisement adv = (Advertisement) request.getAttribute("updateAdv");
		
		try {
			//Felépül egy kapcsolat az adatbázissal
			Connection con = DBConnection.createConnection();
			Statement st = con.createStatement();
			//Frissítjük azokat a title és description adatokat, amelyeknél az id attribútum
			//megegyezik a lekért id attribútummal
			String query = "UPDATE advertisement "
						+ " SET title='"+adv.getTitle()+"', description='"+adv.getDesc()+"'"
						+ " WHERE id='"+adv.getId()+"'";
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
	 * A LoginServlet doPost metódusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
