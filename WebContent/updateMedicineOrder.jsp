<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.medicine.model.Medicine" %>
<%@ page import="com.medicine.service.IMedicineService" %>
<%@ page import="com.medicine.service.MedicineServiceImplementation" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
	<script>
        function validateForm() {
            var patientName = document.forms[0].patientName.value;
            var deliveryAddress = document.forms[0].deliveryAddress.value;
            var email = document.forms[0].email.value;
            var contactNo = document.forms[0].contactNo.value;
            var prescription = document.forms[0].prescription.value;

            if (patientName === "" || deliveryAddress === "" || email === "" || prescription === "") {
                alert("Please fill in all the fields.");
                return false;
            }

            if (contactNo.length < 10) {
                alert("Contact Number should be at least 10 digits.");
                return false;
            }
            
            if (!prescription.includes("drive.google.com")) {
            	alert("Prescription should be uploaded into Google Drive");
            	return false;
            }
            
            if (!email.includes("@")) {
            	alert("Invalid email address");
            	return false;
            }
            
            return true;
        }
    </script>
    <meta charset="ISO-8859-1">
    <title>Medicine Order Update</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            background-image: url("updateBG.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachement: fixed;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #333;
            color: #fff;
            padding: 20px;
        }

        form {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin: 20px auto;
            max-width: 600px;
        }

        form input[type="text"] {
            width: 95%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h1>Update Medicine Order</h1>

    <%
        String orderID = (String) request.getAttribute("OrderID");
        IMedicineService iMedicineService = new MedicineServiceImplementation();
        ArrayList<Medicine> orderList = iMedicineService.getMedicineOrderByID(orderID);
    %>

    <%
        for (Medicine medicine : orderList) {
    %>

            <form action="<%= request.getContextPath() %>/UpdateMedicineOrderServlet" method="post" onsubmit="return validateForm();">
                <input type="hidden" name="OrderID" value="<%= medicine.getOrderID() %>">
                Patient Name <input type="text" name="patientName" value="<%= medicine.getPatientName() %>">
                Delivery Address <input type="text" name="deliveryAddress" value="<%= medicine.getDeliveryAddress() %>">
                Email <input type="text" name="email" value="<%= medicine.getEmail() %>">
                Contact Number <input type="text" name="contactNo" value="<%= medicine.getContactNo() %>">
                Prescription <input type="text" name="prescription" value="<%= medicine.getPrescription() %>">
                <input type="submit" value="Update">
            </form>

    <%
        }
    %>

</body>
</html>