package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TempConverter;

/**
 * Servlet implementation class convertBack
 */
@WebServlet("/convertBack")
public class convertBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public convertBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userDegree = request.getParameter("fid_17");
		
		TempConverter userTemps = new TempConverter(Double.parseDouble(userDegree));
		
		request.setAttribute("userDegree", userTemps);
		
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
