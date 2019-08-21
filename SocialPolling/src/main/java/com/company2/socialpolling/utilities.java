package com.company2.socialpolling;

public class utilities {
	public static boolean isPhoneNumber(String s) {
		int len = s.length();
		if(len < 10)
			return false;
		for(int i = 0; i < len; i++) {
			if(!Character.isDigit(s.charAt(i)))
				return false;
		}
		
		return true;
		
	}
}
