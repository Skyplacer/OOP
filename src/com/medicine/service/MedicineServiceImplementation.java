package com.medicine.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.medicine.model.Medicine;
import com.medicine.util.CommonConstants;
import com.medicine.util.CommonUtil;
import com.medicine.util.DB_Connection;
import com.medicine.util.QueryUtil;

public class MedicineServiceImplementation implements IMedicineService{
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	
	static {
		
		createOrderTable();
	}
	
	public static void createOrderTable() {
		
		try {
			
			connection = DB_Connection.getDB_Connection();
			
			statement = connection.createStatement();
			
			statement.execute(QueryUtil.queryByID(CommonConstants.Query_ID_Create_OrderMedicine_Table));
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Create Table exception" + e.getMessage());
		} finally {
			
			try {
				
				if(connection != null){
					
					connection.close();
				}
				
				if(statement != null) {
					
					statement.close();
				}
				
			} catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
	}

	@Override
	public void addMedicineOrder(Medicine medicine) {
		
		String orderID = CommonUtil.generateOrderIDs(getOrderIDs());
		
		try {
			
			connection = DB_Connection.getDB_Connection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_Insert_Order));
			connection.setAutoCommit(false);
			
			medicine.setOrderID(orderID);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, medicine.getOrderID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, medicine.getPatientName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, medicine.getDeliveryAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, medicine.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, medicine.getContactNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, medicine.getPrescription());
			
			preparedStatement.executeLargeUpdate();
			connection.commit();
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null){
					
					connection.close();
				}
				
				if(preparedStatement != null) {
					
					preparedStatement.close();
				}
				
			} catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
	}

	@Override
	public ArrayList<Medicine> getMedicineOrder() {
		
		ArrayList<Medicine> OrderList = new ArrayList<Medicine>();
		
		try {
			
			connection = DB_Connection.getDB_Connection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ALL_ORDERS));
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Medicine medicine = new Medicine();
				
				medicine.setOrderID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				medicine.setPatientName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				medicine.setDeliveryAddress(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				medicine.setEmail(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				medicine.setContactNo(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				medicine.setPrescription(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				
				OrderList.add(medicine);
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null){
					
					connection.close();
				}
				
				if(preparedStatement != null) {
					
					preparedStatement.close();
				}
				
			} catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
		
		return OrderList;
		
	}

	@Override
	public ArrayList<Medicine> getMedicineOrderByID(String orderID) {
		
		ArrayList<Medicine> OrderList = new ArrayList<Medicine>();
		
		try {
			
			connection = DB_Connection.getDB_Connection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ORDER_BY_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, orderID);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Medicine med = new Medicine();
				
				med.setOrderID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				med.setPatientName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				med.setDeliveryAddress(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				med.setEmail(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				med.setContactNo(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				med.setPrescription(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				
				OrderList.add(med);
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null){
					
					connection.close();
				}
				
				if(preparedStatement != null) {
					
					preparedStatement.close();
				}
				
			} catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
		
		return OrderList;
		
	}

	@Override
	public void updateMedicineOrder(String OrderID, Medicine medicine) {
		
		try {
			
			connection = DB_Connection.getDB_Connection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_UPDATE_ORDER));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, medicine.getPatientName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, medicine.getDeliveryAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, medicine.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, medicine.getContactNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, medicine.getPrescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, medicine.getOrderID());
			
			preparedStatement.executeLargeUpdate();
			connection.commit();
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				
				if(connection != null){
					
					connection.close();
				}
				
				if(preparedStatement != null) {
					
					preparedStatement.close();
				}
				
			} catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
	}

	@Override
	public void deleteMedicineOrder(String OrderID) {
		
		if(OrderID != null && !OrderID.isEmpty()) {
			
			try {
				connection = DB_Connection.getDB_Connection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_DELETE_ORDER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, OrderID);
				
				preparedStatement.execute();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}finally {
				
				try {
					
					if(connection != null){
						
						connection.close();
					}
					
					if(preparedStatement != null) {
						
						preparedStatement.close();
					}
					
				} catch(SQLException e) {
					
					System.out.println(e.getMessage());
					
				}
			}
			
		}
		
	}
	
	public ArrayList<String> getOrderIDs(){
		
		ArrayList<String> ids = new ArrayList<String>();
		
		try {
			
			connection = DB_Connection.getDB_Connection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ORDER_IDS));
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				ids.add(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}finally {
			
			try {
				
				if(connection != null){
					
					connection.close();
				}
				
				if(preparedStatement != null) {
					
					preparedStatement.close();
				}
				
			} catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
		
		return ids;
	}

}
