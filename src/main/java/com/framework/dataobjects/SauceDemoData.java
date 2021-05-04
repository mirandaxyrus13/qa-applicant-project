package com.framework.dataobjects;

import com.framework.core.DataUtility;

public class SauceDemoData {
	public static class UserDetails{
		
		public static String getUsername() throws Exception{
			return DataUtility.getTestData("LS_TS01_TC01", "Username");
		}
		
		public static String getPassword() throws Exception{
			return DataUtility.getTestData("LS_TS01_TC01", "Password");
		}
		
		public static String getProduct() throws Exception{
			return DataUtility.getTestData("LS_TS01_TC01", "Product");
		}
		
		public static String getFirstName() throws Exception{
			return DataUtility.getTestData("LS_TS01_TC01", "First Name");
		}
		
		public static String getLastName() throws Exception{
			return DataUtility.getTestData("LS_TS01_TC01", "Last Name");
		}
		
		public static String getZipPostalCode() throws Exception{
			return DataUtility.getTestData("LS_TS01_TC01", "Zip/Postal Code");
		}

	}
}
