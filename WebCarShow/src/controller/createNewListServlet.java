package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;
import model.ListCarDetails;
import model.Owner;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListCarHelper lih = new ListCarHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String ownerName = request.getParameter("ownerName");
		
		String[] selectedCars = request.getParameterValues("allCarstoAdd");
		List<ListCar> selectedCarsInList = new ArrayList<ListCar>();
		
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedCars != null && selectedCars.length > 0){
			for(int i = 0; i<selectedCars.length; i++) {
			System.out.println(selectedCars[i]);
			ListCar c = lih.searchForCarById(Integer.parseInt(selectedCars[i]));
			selectedCarsInList.add(c);
			}
		}
		
		Owner owner = new Owner(ownerName);
		ListCarDetails lcd = new ListCarDetails(listName,owner);
		lcd.setListOfCars(selectedCarsInList);
		ListCarDetailsHelper slh = new ListCarDetailsHelper();
		slh.insertNewListCarDetails(lcd);
		
		System.out.println("Success!");
		System.out.println(lcd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllCarListsServlet").forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
