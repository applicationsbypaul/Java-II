package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
    }

	/**
	 * Grab the car attributes to be added from the index page.
	 * Create a new car, and a car helper to get it added to the database
	 * Finally reroute back the index.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");

		ListCar car = new ListCar(make,model,year);
		ListCarHelper carHelper = new ListCarHelper();
		carHelper.insertCar(car);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,response);
	}
}
