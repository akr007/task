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
 * A h�rdet�sek l�trehoz�s��rt felel�s controller oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class AddAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * Alap�rtelmezett konstruktor. 
     */
    public AddAdvertisementServlet() {}
    
    /**
	 * Az AddAdvertisementServlet doGet met�dusa, amely t�rli a kiv�lasztott h�rdet�st.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view r�tegbeli CreatePage.jsp-ben szerepl� addAdv objektum lek�r�se
		Advertisement adv = (Advertisement) request.getAttribute("addAdv");
		
		try {
			//Fel�p�l egy kapcsolat az adatb�zissal
			Connection con = DBConnection.createConnection();
			Statement st = con.createStatement();
			//Be�rjuk a t�bl�ba az �j title �s description adatokat
			String query = "INSERT INTO advertisement (title, description) "
						+ " VALUES ('"+adv.getTitle()+"','"+adv.getDesc()+"')";
			st.executeUpdate(query);
			
			//Lek�rj�k a jelenlegi session-t
			HttpSession session = request.getSession();
			AdvertisementModel advModel = new AdvertisementModel();
			//Lek�rj�k az �sszes h�rdet�st
			List<Advertisement> list = advModel.getAllAdvertisement(); 
			//Be�ll�tjuk a k�vetkez� p�rt �s a vez�rl�s �tad�dik a Home oldalra
			session.setAttribute("list", list);
			response.sendRedirect("Home.jsp");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Az AddAdvertisementServlet doPost met�dusa, amely t�rli a kiv�lasztott h�rdet�st.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
