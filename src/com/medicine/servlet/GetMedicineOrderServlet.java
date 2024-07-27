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
 * Servlet implementation class GetMedicineOrderServlet
 */
@WebServlet("/GetMedicineOrderServlet")
public class GetMedicineOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor for the servlet.
     */
    public GetMedicineOrderServlet() {
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
	 * Handles POST requests to retrieve a medicine order by its OrderID.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Get the OrderID parameter from the request to identify the order to retrieve.
		String orderID = request.getParameter("OrderID");
		
		// Create an instance of the Medicine service to retrieve the order by its ID.
		IMedicineService iMedicineService = new MedicineServiceImplementation();
		iMedicineService.getMedicineOrderByID(orderID);
		
		// Set the "OrderID" attribute in the request for further use.
		request.setAttribute("OrderID", orderID);
		
		// Forward the request to an updateMedicineOrder.jsp page for displaying or updating the medicine order.
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateMedicineOrder.jsp");
		dispatcher.forward(request, response);
	}
}