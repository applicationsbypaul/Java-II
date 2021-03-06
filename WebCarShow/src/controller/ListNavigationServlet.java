package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCarDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listnavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			getServletContext().getRequestDispatcher
			("/viewAllCarListsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListCarDetails listToDelete = dao.searchForListCarDetailsById(tempId);
				dao.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
				
			} finally {
				getServletContext().getRequestDispatcher("/viewAllCarListsServlet").forward(request, response);
			}
		}else if (act.equals("edit")){
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListCarDetails listToEdit = dao.searchForListCarDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				ListCarHelper daoForCars = new ListCarHelper();
				
				request.setAttribute("allCars", daoForCars.showAllCars());
				
				if(daoForCars.showAllCars().isEmpty()){
					request.setAttribute("allCars", " ");
					}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				} catch (NumberFormatException e) {
			getServletContext().getRequestDispatcher("/viewAllCarListsServlet").forward(request, response);

			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
