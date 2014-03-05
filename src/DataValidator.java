package DataValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chaitanya Garikiparthi
 * A Utility class that can be used to do various string pattern matching and 
 * to verify data integrity. 
 * 
 * Utility functions provided to remove empty spaces, check for string values to be non 
 * empty, check for email address strings to have certain format, phone numbers to be numeric etc.
 */
public class DataValidator {
	
	private static String nonBlankPattern = ".+";
	private static String alphaNumericPattern = "[a-zA-Z0-9]+"; 
	private static String alphaPattern ="[a-zA-Z]+";
	private static String phonePattern = "\\d{10}";
	private static String emailPattern = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
	
	private static String outString = "";
	
	/**
	 * Utility function to be called by various string validation functions.
	 */
	public static boolean isValidInput(String input, String pattern)
	{
		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(input);
		return match.matches();
	}
	
	/**
	 * Utility function to remove blank spaces
	 */
	public static String removeBlankSpaces(String str)
	{
		return str.replaceAll("\\s+", "");
	}
	
	/**
	 * Utility function to remove numeric characters
	 */
	public static String removeNumericChars(String str)
	{
		return str.replaceAll("[0-9]+","");
	}
	
	/**
	 * Utility function to remove non-numeric characters
	 */
	public static String removeNonNumericChars(String str)
	{
		return str.replaceAll("[^0-9]+","");
	}
	
	/**
	 * Check if name is a non empty alpha-numeric string
	 */
	public static String validateName(String name)
	{
		
		outString = "";
		
		Boolean result = isValidInput(removeBlankSpaces(name), alphaNumericPattern);
		if(result == false) 
			outString = "FirstName has to be a non empty alpha-numeric string.";
		
		return outString;
	}
	
	/**
	 * Check if Member ID received as a string is blank
	 */
	public static String validateMemberID(String memberID)
	{
		
		outString = "";
		
		if(removeBlankSpaces(memberID).length() == 0) 
			outString = "Member ID cannot be empty.";
		
		return outString;
	}
	
	/**
	 * Check if phone number received as a string is atleast a 10 digit numeric value
	 */
	public static String validatePhoneNumber(String phoneNumber)
	{
		
		outString = "";
		
		Boolean result = isValidInput(removeNonNumericChars(phoneNumber), phonePattern);
		if(result == false) outString = "Phone number has to be a 10 digit number.";
		
		return outString;
	}
	
	
	/**
	 * Check if email address is formatted properly. Type used as reference is xxx@xxx.xxx
	 */
	public static String validateEmailAddress(String emailAddress)
	{
		
		outString = "";
		
		Boolean result = isValidInput(emailAddress, emailPattern);
		if(result == false) outString = "Email address should be in xxx@xxx.xxx.";
		
		return outString;
	}
		
	
}
