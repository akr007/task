package teszt.controller;
 
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teszt.data.Advertisement;
import teszt.data.User;
import teszt.model.AdvertisementModel;
import teszt.model.LoginModel;

/**
 * A bejelentkez�s�rt felel�s controller oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alap�rtelmezett konstruktor
	 */
	public LoginServlet() {}
	
	/**
	 * A LoginServlet doGet met�dusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
 
	/**
	 * A LoginServlet doPost met�dusa, amely v�grehajtja a bejelentkez�st �s az azonos�t�st.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//Objektumh�v�sok
        User user = new User(); 
        LoginModel model = new LoginModel();
        AdvertisementModel adv = new AdvertisementModel(); 
        List<Advertisement> list = adv.getAllAdvertisement();
        
        //A k�t inputk�nt megadott adat
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //Be�ll�tjuk �s �tadjuk a k�t kapott adatot a model r�teg egy met�dus�nak
        user.setEmail(email); 
        user.setPassword(password);
        //A met�dus eld�nti, hogy szerepel-e az adatb�zisban a megadott inputp�r
        String validate = model.authenticateUser(user);
        
        //Ha OK v�lasszal t�rt vissza a met�dus
        if(validate.equals("OK")) {
        	 //Be�ll�tjuk a k�vetkez� p�rokat
             request.setAttribute("email", email); 
             request.setAttribute("list", list);
             //A vez�rl�s �tad�dik a Home oldalra
             request.getRequestDispatcher("/Home.jsp").forward(request, response);
         } else {
        	 //ellenben a Login oldalra megy�nk tov�bb
             request.setAttribute("errMessage", validate); 
             request.getRequestDispatcher("/Login.jsp").forward(request, response);
         }
    }
}