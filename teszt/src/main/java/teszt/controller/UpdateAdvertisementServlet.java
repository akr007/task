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
 * A hirdet�sek friss�t�s�t elv�gz� controller oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class UpdateAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Alap�rtelmezett konstruktor. 
     */
    public UpdateAdvertisementServlet() {}

    /**
	 * Az UpdateAdvertisementServlet doGet met�dusa, amely friss�ti az egyes h�rdet�seket.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view r�tegbeli UpdatePage.jsp-ben szerepl� updateAdv objektum lek�r�se
		Advertisement adv = (Advertisement) request.getAttribute("updateAdv");
		
		try {
			//Fel�p�l egy kapcsolat az adatb�zissal
			Connection con = DBConnection.createConnection();
			Statement st = con.createStatement();
			//Friss�tj�k azokat a title �s description adatokat, amelyekn�l az id attrib�tum
			//megegyezik a lek�rt id attrib�tummal
			String query = "UPDATE advertisement "
						+ " SET title='"+adv.getTitle()+"', description='"+adv.getDesc()+"'"
						+ " WHERE id='"+adv.getId()+"'";
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
	 * A LoginServlet doPost met�dusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
