package com.medicine.service;

import java.util.ArrayList;
import com.medicine.model.Medicine;

public interface IMedicineService {
	
	// Adds a new medicine order to the service.
	public void addMedicineOrder(Medicine medicine);
	
	// Retrieves a list of all medicine orders.
	public ArrayList<Medicine> getMedicineOrder();
	
	// Retrieves a list of medicine orders by a specific order ID.
	public ArrayList<Medicine> getMedicineOrderByID(String orderID);
	
	// Updates an existing medicine order with the given order ID.
	public void updateMedicineOrder(String OrderID, Medicine medicine);
	
	// Deletes a medicine order with the given order ID.
	public void deleteMedicineOrder(String OrderID);
}