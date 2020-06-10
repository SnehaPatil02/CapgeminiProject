package com.capgemini.healthcare.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public static boolean idVal(String id)
	{
		try {
			long l = Long.parseLong(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
public static boolean nameVal(String name) {
		
		return ((name != null) && (!name.equals(""))&& (name.matches("^[a-zA-Z]*$")));
	}
	
public static boolean passwordVal(String password) {
	String pwdregex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	Pattern pattern = Pattern.compile(pwdregex);
	Matcher matcher = pattern.matcher((CharSequence)password);
	return matcher.matches();
}

}
