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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListCarDetailsHelper dao = new ListCarDetailsHelper();
		ListCarHelper lih = new ListCarHelper();
		OwnerHelper ow = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListCarDetails listToUpdate = dao.searchForListCarDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String ownerName = request.getParameter("ownerName");
		Owner newOwner = ow.findOwner(ownerName);
		
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allCarsToAdd");
			List<ListCar> selectedItemsInList = new
			ArrayList<ListCar>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListCar c =	lih.searchForCarById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfCars(selectedItemsInList);
			} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<ListCar> selectedCarsInList = new ArrayList<ListCar>();
				listToUpdate.setListOfCars(selectedCarsInList);
				}
		
				listToUpdate.setListName(newListName);
				listToUpdate.setOwner(newOwner);
				dao.updateList(listToUpdate);
				getServletContext().getRequestDispatcher("/viewAllCarListsServlet").forward(request, response);
						}

}
