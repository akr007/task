package teszt.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teszt.connection.DBConnection;
import teszt.data.Advertisement;

/**
 * A hirdet�sek l�trehoz�s��rt felel�s controller oszt�ly.
 * @author Antal Kriszti�n
 *
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alap�rtelmezett konstruktor
	 */
    public CreateServlet() {}

    /**
	 * A CreateServlet doGet met�dusa, amely tov�bbk�ld a Create.jsp view oszt�lyhoz.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/Create.jsp").forward(request, response);
	}
	
	/**
	 * A CreateServlet doPost met�dusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
