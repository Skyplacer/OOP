package com.medicine.util;

public class CommonConstants {
	
	// Constants related to query XML and properties files.
	public static final String Query_XML = "queryfilepath";
	public static final String Propery_FILE = "config.properties";
	public static final String TAG_NAME = "query";
	public static final String ATTRIBUTE_NAME = "id";
	
	// Constants for common characters and elements.
	public static final String COMMA = ",";
	
	// Database connection properties.
	public static final String URL = "url";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String DRIVER_NAME = "drivername";
	
	// Column indices for database queries.
	public static final int COLUMN_INDEX_ONE = 1;
	public static final int COLUMN_INDEX_TWO = 2;
	public static final int COLUMN_INDEX_THREE = 3;
	public static final int COLUMN_INDEX_FOUR = 4;
	public static final int COLUMN_INDEX_FIVE = 5;
	public static final int COLUMN_INDEX_SIX = 6;
	
	// MedicineOrder Constants
	public static final String Order_ID_PREFIX = "OID100";
	public static final String Query_ID_Create_OrderMedicine_Table = "create_OrderMedicine_table";
	public static final String Query_ID_Insert_Order = "insert_order"; 
	public static final String Query_ID_GET_ORDER_IDS = "get_order_ids";
	public static final String Query_ID_GET_ALL_ORDERS = "get_all_orders";
	public static final String Query_ID_GET_ORDER_BY_ID = "get_order_by_id";
	public static final String Query_ID_UPDATE_ORDER = "update_order";
	public static final String Query_ID_DELETE_ORDER = "delete_order";
}