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
 * A bejelentkezésért felelõs controller osztály.
 * @author Antal Krisztián
 *
 */
public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alapértelmezett konstruktor
	 */
	public LoginServlet() {}
	
	/**
	 * A LoginServlet doGet metódusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
 
	/**
	 * A LoginServlet doPost metódusa, amely végrehajtja a bejelentkezést és az azonosítást.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//Objektumhívások
        User user = new User(); 
        LoginModel model = new LoginModel();
        AdvertisementModel adv = new AdvertisementModel(); 
        List<Advertisement> list = adv.getAllAdvertisement();
        
        //A két inputként megadott adat
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //Beállítjuk és átadjuk a két kapott adatot a model réteg egy metódusának
        user.setEmail(email); 
        user.setPassword(password);
        //A metódus eldönti, hogy szerepel-e az adatbázisban a megadott inputpár
        String validate = model.authenticateUser(user);
        
        //Ha OK válasszal tért vissza a metódus
        if(validate.equals("OK")) {
        	 //Beállítjuk a következõ párokat
             request.setAttribute("email", email); 
             request.setAttribute("list", list);
             //A vezérlés átadódik a Home oldalra
             request.getRequestDispatcher("/Home.jsp").forward(request, response);
         } else {
        	 //ellenben a Login oldalra megyünk tovább
             request.setAttribute("errMessage", validate); 
             request.getRequestDispatcher("/Login.jsp").forward(request, response);
         }
    }
}