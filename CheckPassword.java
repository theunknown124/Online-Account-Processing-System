public class CheckPassword {

	/*
	* Validates content of a password returning a code value
	* @param password
	* @return 0 - password is valid
			* 1 - wrong size.
			* 2 - does not consist of only letters, digits, and
			* special characters
			* 3 - does not contain at least one upper case and one
			* lower case character
			* 4 - does not contain at least two digits an invalid
			* character
			* 5 - does not contain any of @, #, $, or %
			*/
			
	public static int checkPassword(String password) {
		if (hasValidSize(password) == false)
			return 1;
		if(hasValidCharacters(password) == false)
			return 2;
		if(hasUpperLowerCase(password) == false)
			return 3;
		if(hasTwoDigits(password) == false)
			return 4;
		if(hasSpecialCharacters(password) == false)
			return 5;// Add calls to other methods here
		return 0;
	}
	public static boolean hasValidSize(String password) {
		int numberOfCharacters = password.length();
		if (numberOfCharacters > 32 || numberOfCharacters < 8)
			return false;
		return true;
	}
	
	public static boolean hasValidCharacters(String password) {
		
		//boolean validCharacters = true;
		
		for (int s = 0; s < password.length(); s++) {
			
			char c = password.charAt(s);
			
		if (!('0' <= c && c <= '9')) 
			//validCharacters = false;
		
			if(!('a' <= c && c <= 'z')) 
			//validCharacters = false;
		
				if (!('A' <= c && c <= 'Z')) 
			//validCharacters = false;
					
					
					if(!(c == '@' || c == '#' || c == '$' || c == '%'))
		
						//if (if it's not an allowable special character)
						
		return false;
		
		}
		return true;
		
		
	}
	public static boolean hasUpperLowerCase(String password) {
		boolean valid = false;
		boolean hasLower = false;
		boolean hasUpper = false;
		
		for (int j = 0; j < password.length(); j++) {

			char Ul = password.charAt(j);
			
			if (Character.isUpperCase(Ul)) {
				hasUpper = true;
				
			}
			if (Character.isLowerCase(Ul)){
				hasLower = true;
			}
			
			
		}
		
		valid = hasUpper && hasLower;
		return valid;
	}

	public static boolean hasTwoDigits(String password) {
	
	int numberCounter = 0;
		for (int i = 0; i < password.length(); i++) {
			
			char ch = password.charAt(i);
			
			if(Character.isDigit(ch)) {
				numberCounter++;
				
			}
			
			if (numberCounter >=2) {
				return true;
			}
			
		
	}
		return false;
		
}
	public static boolean hasSpecialCharacters(String password) {
		for (int i = 0; i < password.length(); i++) {
			
			char ch = password.charAt(i);
			
			if(ch == '@' || ch == '#' || ch == '$' || ch == '%'){
				return true;
			}
		
		}
		return false;
}

}
