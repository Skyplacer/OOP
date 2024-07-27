<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            background-image: url("MedicineDelivery.jpeg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachement: fixed;
        }
        
        .container {
            background-color: #808080;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            margin-top: 200px;
        }

        h1 {
            color: #333;
        }

        thank {
            font-size: 24px;
            color: #4CAF50;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Order has been successfully processed</h1>
        <p>Thank you for your order!</p>
        <button onclick="location.href='homepage.jsp'">Return to Homepage</button>
    </div>
</body>
</html>