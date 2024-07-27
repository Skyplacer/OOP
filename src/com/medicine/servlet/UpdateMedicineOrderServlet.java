package com.medicine.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicine.model.Medicine;
import com.medicine.service.IMedicineService;
import com.medicine.service.MedicineServiceImplementation;

/**
 * Servlet implementation class UpdateMedicineOrderServlet
 */
@WebServlet("/UpdateMedicineOrderServlet")
public class UpdateMedicineOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor for the servlet.
     */
    public UpdateMedicineOrderServlet() {
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
	 * Handles POST requests to update a medicine order.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Create a new Medicine object to store updated order details.
		Medicine medicine = new Medicine();
		
		// Get the OrderID parameter from the request to identify the order to update.
		String orderID = request.getParameter("OrderID");
		
		// Set the attributes of the Medicine object from the request parameters.
		medicine.setOrderID(orderID);
		medicine.setPatientName(request.getParameter("patientName"));
		medicine.setDeliveryAddress(request.getParameter("deliveryAddress"));
		medicine.setEmail(request.getParameter("email"));
		medicine.setContactNo(request.getParameter("contactNo"));
		medicine.setPrescription(request.getParameter("prescription"));
		
		// Create an instance of the Medicine service to update the order.
		IMedicineService iMedicineService = new MedicineServiceImplementation();
		iMedicineService.updateMedicineOrder(orderID, medicine);
		
		// Set the "medicine" attribute in the request for further use.
		request.setAttribute("medicine", medicine);
		
		// Forward the request to an allMedicineOrder.jsp page for displaying or processing all medicine orders.
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allMedicineOrder.jsp");
		dispatcher.forward(request, response);
	}
}