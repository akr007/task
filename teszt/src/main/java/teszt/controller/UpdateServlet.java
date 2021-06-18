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
 * A hirdet�sek friss�t�sre val� kiv�laszt�s��rt felel�s controller oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alap�rtelmezett konstruktor
	 */
    public UpdateServlet() {}

    /**
	 * Az UpdateServlet doGet met�dusa, amely kiv�lasztja az egyes h�rdet�seket friss�t�sre.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//A view r�tegbeli Home.jsp-ben szerepl� advId objektum lek�r�se
		int id = Integer.parseInt(request.getParameter("advId"));
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
        	//Fel�p�l egy kapcsolat az adatb�zissal
        	con = DBConnection.createConnection();
    		st = con.createStatement(); 
    		//Kiv�lasztjuk azokat a title �s a description mez�ket az advertisement t�bl�b�l,
    		//ahol az id attrib�tum megegyezik a advId mez�vel
            rs = st.executeQuery("SELECT title, description FROM advertisement "
            		+ "WHERE id='"+id+"'");
            
            while(rs.next()) {
            	//A kiv�lasztott adatokat elmentj�k
            	Advertisement adv = new Advertisement();
            	adv.setId(id);
            	adv.setTitle(rs.getString("title"));
            	adv.setDesc(rs.getString("description"));
            	//Be�ll�tjuk a k�vetkez� p�rt �s a vez�rl�s �tad�dik a Update oldalra
            	request.setAttribute("adv", adv);
            	request.getRequestDispatcher("/Update.jsp").forward(request, response);
            }
        } catch(SQLException e) {
            e.printStackTrace();
     }
	}
	
	/**
	 * Az UpdateServlet doPost met�dusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
