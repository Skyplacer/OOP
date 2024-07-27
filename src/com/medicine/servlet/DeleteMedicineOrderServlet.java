package com.medicine.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicine.service.IMedicineService;
import com.medicine.service.MedicineServiceImplementation;

/**
 * Servlet implementation class DeleteMedicineOrderServlet
 */
@WebServlet("/DeleteMedicineOrderServlet")
public class DeleteMedicineOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor for the servlet.
     */
    public DeleteMedicineOrderServlet() {
        super();
    }

	/**
	 * Handles GET requests (not used in this example).
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Handles POST requests to delete a medicine order.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Get the OrderID parameter from the request to identify the order to delete.
		String OrderID = request.getParameter("OrderID");
		
		// Create an instance of the Medicine service to delete the order.
		IMedicineService iMedicineService = new MedicineServiceImplementation();
		iMedicineService.deleteMedicineOrder(OrderID);
		
		// Set the "OrderID" attribute in the request for further use.
		request.setAttribute("OrderID", OrderID);
		
		// Forward the request to an allMedicineOrder.jsp page for displaying or processing all medicine orders.
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allMedicineOrder.jsp");
		dispatcher.forward(request, response);
	}
}