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
 * A h�rdet�sek t�rl�s��rt felel�s controller oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class DeleteAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Alap�rtelmezett konstruktor. 
     */
    public DeleteAdvertisementServlet() {}

    /**
	 * A DeleteAdvertisementServlet doGet met�dusa, amely t�rli a kiv�lasztott h�rdet�st.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view r�tegbeli Home.jsp-ben szerepl� advId objektum lek�r�se
		int id = Integer.parseInt(request.getParameter("advId"));
		try {
			//Fel�p�l egy kapcsolat az adatb�zissal
			Connection con = DBConnection.createConnection();
			Statement st = con.createStatement();
			//T�r�lj�k azokat a sorokat az adatb�zisb�l,
			//ahol az id attrib�tum megegyezik a lek�rt id-vel
			st.executeUpdate("DELETE FROM advertisement WHERE id='"+id+"'");
			
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
	 * A DeleteAdvertisementServlet doPost met�dusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
