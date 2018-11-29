package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
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
		//doGet(request, response);
		
		ListItemHelper dao = new ListItemHelper();
		String act = request.getParameter("doThisToItem");
		
		if(act ==null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllServlet").forward(request, response);
		}
		else if (act.equals("Delete Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("itemID"));
			Item itemToDelete = dao.searchForItemByItemID(tempId);
			dao.deleteItem(itemToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllVinylServlet").forward(request, response);
		}
		else if(act.equals("Edit Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("itemID"));
			Item itemToEdit = dao.searchForItemByItemID(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/editItem.jsp").forward(request, response);
		}
		else if(act.equals("Add New Item")) {
			getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		}
		
	}

}
