<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "com.medicine.model.Medicine" %>
<%@ page import = "com.medicine.service.IMedicineService" %>
<%@ page import = "com.medicine.service.MedicineServiceImplementation" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Orders</title>
<script>
	function confirmDelete(){
		
		if(confirm("Are you sure you want to delete this row? ")){
			return true;
		} else{
			return false;
		}
	}
</script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        text-align: center;
        background-image: url("updateBG.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        background-attachement: fixed;
    }

    h1 {
        color: #333;
    }

    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px auto;
        margin-top: 150px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }
    
    tr{
    	background-color: #ffffff;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2; 
    }

    tr:hover {
        background-color: #ddd;
    }

    form {
        display: inline;
    }
    
    input {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

    input:hover {
            background-color: #45a049;
        }
    header {
            background-color: #0074D9;
            color: white;
            padding: 10px;
            text-align: center;
            position: absolute;
            top: 0;
    		left: 0;
    		right: 0;
    		width: 100%;
        }
        
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: absolute;
            bottom: -250px;
    		left: 0;
    		right: 0;
    		width: 100%;
        }
        
        nav {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 30px 50px;
            position: absolute;
            top: 117px;
    		left: 0;
    		right: 0;
    		width: 100%;
        }

        nav a {
            text-decoration: none;
            color: white;
            padding: 20px 30px;
        }

        nav a:hover {
            background-color: #555;
        }
        
</style>
</head>
<body>
	<header>
        <h1>Welcome to E-Channelling</h1>
        <a onclick="location.href='AdminControl.jsp'" href="#">Admin Control Panel</a>
    </header>
    <nav>
        <a onclick="location.href='homepage.jsp'" href="#">Home</a>
        <a href="#">Schedule Appointment</a>
        <a onclick="location.href='order.jsp'" href="#">Order Medicine</a>
        <a href="#">FAQ</a>
        <a href="#">About Us</a>
        <a href="#">Contact Us</a>
    </nav>

    <h1> All Medicine Orders </h1>

    <table>
        <thead>
            <tr>
                <th> Order ID </th>
                <th> Patient Name </th>
                <th> Delivery Address </th>
                <th> Email </th>
                <th> Contact Number </th>
                <th> Prescription </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>
        </thead>
        <tbody>

            <%
                IMedicineService iMedicineService = new MedicineServiceImplementation();
                ArrayList<Medicine> orderList = iMedicineService.getMedicineOrder();
            %>

            <%
                for(Medicine medicine: orderList){
            %>

                <tr>
                    <td><%= medicine.getOrderID() %> </td>
                    <td><%= medicine.getPatientName() %> </td>
                    <td><%= medicine.getDeliveryAddress() %> </td>
                    <td><%= medicine.getEmail() %> </td>
                    <td><%= medicine.getContactNo() %> </td>
                    <td><%= medicine.getPrescription() %> </td>

                    <td>
                        <form action="<%= request.getContextPath()%>/GetMedicineOrderServlet" method="post" > 
                            <input type="hidden" name="OrderID" value = "<%= medicine.getOrderID() %>">
                            <input type="submit" value="Edit">
                        </form>
                    </td>

                    <td>
                        <form action="<%= request.getContextPath()%>/DeleteMedicineOrderServlet" method="post" onsubmit="return confirmDelete();"> 
                            <input type="hidden" name="OrderID" value = "<%= medicine.getOrderID() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>

            <%
                }
            %>

        </tbody>
    </table>
	
	<footer>
        &copy; 2023 E-Channelling. All rights reserved.
    </footer>
</body>
</html>