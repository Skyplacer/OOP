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
 * Servlet implementation class AddMedicineOrderServlet
 */
@WebServlet("/AddMedicineOrderServlet")
public class AddMedicineOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor for the servlet.
     */
    public AddMedicineOrderServlet() {
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
	 * Handles POST requests to add a medicine order.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Create a new Medicine object to store order details.
		Medicine medicine = new Medicine();
		
		// Set the attributes of the Medicine object from the request parameters.
		medicine.setPatientName(request.getParameter("patientName"));
		medicine.setDeliveryAddress(request.getParameter("deliveryAddress"));
		medicine.setEmail(request.getParameter("email"));
		medicine.setContactNo(request.getParameter("contactNo"));
		medicine.setPrescription(request.getParameter("prescription"));
		
		// Create an instance of the Medicine service to add the order.
		IMedicineService iMedicineService = new MedicineServiceImplementation();
		iMedicineService.addMedicineOrder(medicine);
		
		// Set the "medicine" attribute in the request for further use.
		request.setAttribute("medicine", medicine);
		
		// Forward the request to a success.jsp page for displaying success or further processing.
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/success.jsp");
		dispatcher.forward(request, response);
	}
}