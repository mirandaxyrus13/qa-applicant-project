package com.framework.dataobjects;

import com.framework.core.DataUtility;

public class GoReactData {
	
	public static class RegistrationDetails{
		
		public static String getFirstName(String value) throws Exception{
			return DataUtility.getTestData(value, "First Name");
		}
		
		public static String getLastName(String value) throws Exception{
			return DataUtility.getTestData(value, "Last Name");
		}
		
		public static String getPhoneNumber(String value) throws Exception{
			return DataUtility.getTestData(value, "Phone Number");
		}
		
		public static String getEmail(String value) throws Exception{
			return DataUtility.getTestData(value, "Email");
		}
		
		public static String getPassword(String value) throws Exception{
			return DataUtility.getTestData(value, "Password");
		}
		
		public static String getTermsAndPrivacy(String value) throws Exception{
			return DataUtility.getTestData(value, "Terms and Privacy");
		}
		
		public static String getInstitutionName(String value) throws Exception{
			return DataUtility.getTestData(value, "Institution Name");
		}
		
		public static String getYourRole(String value) throws Exception{
			return DataUtility.getTestData(value, "Your Role");
		}
		
		public static String getType(String value) throws Exception{
			return DataUtility.getTestData(value, "Type");
		}
		
		public static String getCourseFormat(String value) throws Exception{
			return DataUtility.getTestData(value, "Course Format");
		}
	}
}
