<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script>
    
    function enablebutton() {
        var patientName = document.getElementById("patientName").value;
        var deliveryAddress = document.getElementById("deliveryAddress").value;
        var email = document.getElementById("email").value;
        var contactNo = document.getElementById("contactNo").value;
        var prescription = document.getElementById("prescription").value;
        var tickbox = document.getElementById("acceptTickbox");
        var submit = document.getElementById("submit");

        if (patientName === '' || deliveryAddress === '' || email === '' || contactNo === '' || prescription === '') {
            submit.disabled = true;
        } else {
            submit.disabled = !tickbox.checked;
        }
    }
    
    var inputFields = document.querySelectorAll('input[type="text"]');
	inputFields.forEach(function (input){
		input.addEventListener('input', enablebutton);
	});
	
	var checkbox = document.getElementById("acceptTickbox");
	checkbox.addEventListener('change', enablebutton);
   
    </script>
    <title>Medicine Order Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            background-image: url("MedicineDelivery.jpeg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachement: fixed;
            text-align: center;
        }
        
        .container {
            background-color: #808080;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            margin-top: 215px;
        }

        h1 {
            color: #fff;
        }

        form {
            text-align: left;
            width: 575px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
         .tooltip {
            position: relative;
            display: inline-block;
            cursor: pointer;
            width: 575px;
        }

        .tooltip .info-icon {
            position: relative;
            display: inline-block;
            cursor: pointer;
        }

        .tooltip .info-icon:before {
            content: "?";
            position: absolute;
            color: #0078d4;
            font-weight: bold;
            font-size: 16px;
            top: 0;
            right: -25px;
        }

        .tooltip .info-icon:hover + .tooltiptext {
            display: block;
        }

        .tooltiptext {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 10px;
            width: 420px;
            top: -20px; 
            left: 50%; 
            z-index: 1;
        }
        
        button {
        	background-color: #228b22;
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
            bottom: -150px;
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
    <div class="container">
        <h1>Insert Medicine Order</h1>
        <form action="<%= request.getContextPath() %>/AddMedicineOrderServlet" method="post" onclick="enablebutton()">
            <label for="patientName">Patient Name</label>
            <input type="text" name="patientName" id="patientName" required>

            <label for="deliveryAddress">Delivery Address</label>
            <input type="text" name="deliveryAddress" id="deliveryAddress" required>

            <label for="email">Email</label>
            <input type="text" name="email" id="email" required>

            <label for="contactNo">Contact Number</label>
            <input type="text" name="contactNo" id="contactNo" required>

            <div class="tooltip">
                <span class="info-icon">Prescription PDF (Google Drive URL)</span>
                <div class="tooltiptext">
                    How to add a file to Google Drive and get its download link:<br><br>
                    1. Upload your file to Google Drive.<br>
                    2. Right-click on the file and select "Get shareable link".<br>
                    3. Set the sharing settings to "Anyone with the link".<br>
                    4. Copy the link provided.
                </div>
                <input type="text" name="prescription" id="prescription" required>
            </div>
			
			<label>
				 <input type="checkbox" id="acceptTickbox">
				 I accept <a href="termsAndConditions.jsp"> terms and conditions</a>
			</label>
			<br>
			<button type ="submit" id="submit" disabled onclick="location.href='success.jsp'">Add Order</button>
        </form>
    </div>
    <footer>
        &copy; 2023 E-Channelling. All rights reserved.
    </footer>
</body>
</html>