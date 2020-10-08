package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Confirm if user has selected a car to remove, edit, or add a car
	 * redirect to correct page if add or edit has been selected
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListCarHelper carHelper = new ListCarHelper();
		String act = request.getParameter("doThisToCar");
		
		String path = "/viewAllCarsServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListCar carToDelete = carHelper.searchForCarById(tempId);
				carHelper.deleteCar(carToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListCar carToEdit = carHelper.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path ="/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car to edit.");
			}
			
		} else if (act.equals("add")) {
			path ="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
