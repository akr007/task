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
 * A hirdetések létrehozásáért felelõs controller osztály.
 * @author Antal Krisztián
 *
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alapértelmezett konstruktor
	 */
    public CreateServlet() {}

    /**
	 * A CreateServlet doGet metódusa, amely továbbküld a Create.jsp view osztályhoz.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/Create.jsp").forward(request, response);
	}
	
	/**
	 * A CreateServlet doPost metódusa.
	 * @param request HttpServletRequest objektum
	 * @param response HttpServletResponse objektum
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
