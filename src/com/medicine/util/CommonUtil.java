package com.medicine.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CommonUtil {
	
	// Properties for configuration settings.
	public static final Properties properties = new Properties();
	
	static {
		// Load configuration properties from a file.
		try {
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.Propery_FILE));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Generate unique order IDs based on the existing list of IDs.
	 * 
	 * @param ids A list of existing order IDs.
	 * @return A new unique order ID.
	 */
	public static String generateOrderIDs(ArrayList<String> ids) {
		
		String id;
		
		// Calculate the next order ID based on the size of the existing list.
		int next = ids.size();
		id = CommonConstants.Order_ID_PREFIX + next;
		
		// If the generated ID already exists in the list, increment and retry.
		if (ids.contains(id)) {
			next++;
			id = CommonConstants.Order_ID_PREFIX + next;
		}
		
		return id;
	}
}