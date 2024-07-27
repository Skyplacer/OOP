package com.medicine.model;

public class Medicine {
	
	// Member variables
	private String OrderID;           
	private String PatientName;       
	private String DeliveryAddress;   
	private String Email;            
	private String ContactNo;        
	private String Prescription;     
	
	// Constructor
	public Medicine() {
		// Default values for member variables
		OrderID = "default";
		PatientName = "default";
		DeliveryAddress = "default";
		Email = "default";
		ContactNo = "default";
		Prescription = "default";
	}
	
	// Getter and Setter methods for member variables
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getPrescription() {
		return Prescription;
	}
	public void setPrescription(String prescription) {
		Prescription = prescription;
	}
}