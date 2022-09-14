

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Meba Tadesse
 *
 */

public class PasswordCheckerUtility {


	/**
	 * checks all other requirements 
	 * @param password string to be checked for 
	 * @return true if the password is valid
	 * 	 */
	public static boolean isValidPassword(String password) throws Exception {

		if (isValidLength(password)) //Checks the length first
		{
			return hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) 
					&& hasSpecialChar(password) && NoSameCharInSequence(password); // Return true if the password is valid
				
		}
		return false;
	}

	/**
	 * checks if the password has length between six and nine chars
	 * @param password string to checked for length
	 * @return true if the length is appropriate
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		if(password.length() <= 9 && password.length() >= 6)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * checks if the password is weak
	 * @param password sting to be checked for
	 * @return true if it is
	 * @throws WeakPasswordException thrown if is not
	 */
	static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		try
		{
			if (!(hasBetweenSixAndNineChars(password)) && isValidPassword(password)) //Checks if the password is not valid and not between 6 and 9 inclusively
				return false;
		}
		catch (Exception e)
		{
			throw new WeakPasswordException();
		}
		throw new WeakPasswordException();
	}


	
	/**
	 * returns strings that don't have requirements
	 * @param password string to be checked for 
	 * @return arraylist of strings that are invalid to be passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> password) {
		
			ArrayList<String> invalidPassword = new ArrayList<String>();
			
			for (String temp : password) { //Checks every password in the ArrayList
			try{
				isValidPassword(temp);
				}
			
			catch( Exception e) {
				invalidPassword.add(temp + " -> " + e.getMessage());
			}
		}
		return invalidPassword;
	}
	
	
	/**
//	 * compares the given password string with the correct one
//	 * @param password password string to be checked for
//	 * @param passwordConfirm string to be checked against password for 
//	 * @throws UnmatchedException thrown if not same
//	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{

		if (!(password.equals(passwordConfirm))) //Checks if the password and it confirm does not match
		{
			throw new UnmatchedException();
		}
		
	}
	
	
	/**
	 * compares a string with the correct password
	 * @param password password string to be checked for
	 * @param passwordConfirm string to be checked against password for 
	 * @return false if not same
	 */

	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		
		if (password.equals(passwordConfirm)) //Checks if the password and it confirm match
		{
				return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * checks if the password has more than 6 chars
	 * @param password string to be checked for length
	 * @return true if the string has more than 5 chars
	 * @throws LengthException thrown if the length is less than 6 chars
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6) { // Checks that the password is less than 6 characters
			throw new LengthException();
		}
		return true;

	}
	
	/**
	 * checks if the password has digit char
	 * @param password string to be checked for digit char
	 * @return true if the string has digit char
	 * @throws NoDigitException thrown if the string does not have digit char
	 */
	static boolean hasDigit(String password) throws NoDigitException
	{
		String[] temp = password.split("");
        for (String s : temp) //Checks every password in the ArrayList 
        	
		if (s.matches(".*\\d.*")) // Checks that the password has a digit
		{
			return true;
		}
        throw new NoDigitException();
	}

	
	/**
	 * checks if the is lower case
	 * @param password
	 * @return true if there is a llower case
	 * @throws NoLowerAlphaException thrown if ther is none
	 */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
    {
    	String[] temp = password.split("");
        for (String s : temp) //Checks every password in the ArrayList 
        	
            if (s.matches("[a-z]"))  // Checks that the password has a lower case letter
            {
                return true;
            }
        
        throw new NoLowerAlphaException();

    }

    /**
	 * checks if the password has a special char
	 * @param password string to be checked for special char
	 * @return true if the string contains special char
	 * @throws NoSpecialCharacterException thrown if there is no special char
	 */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
    {
        String[] temp = password.split("");
        for (String s : temp)  //Checks every password in the ArrayList 
        {
            if (s.matches("[^\\w]")) // Checks that the password has a special character
            {
                return true;
            }
        }
        throw new NoSpecialCharacterException();

    }

    /**
	 * checks if the password has upper case char
	 * @param password string to be checked for upper case
	 * @return true if the string has upper case letter
	 * @throws NoUpperAlphaException thrown if the string does not have upper case char
	 */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
    {
        String[] temp = password.split("");  //Checks every password in the ArrayList 
        for (String s : temp)
        {
            if (s.matches("[A-Z]")) // Checks that the password has an upper case letter
            {
                return true;
            }
        }
        throw new NoUpperAlphaException();

    }

    /**
	 * checks the password for sequence requirement
	 * @param password  string to be checked for Sequence requirement
	 * @return false if it does not meet
	 * @throws InvalidSequenceException thrown if there is same char in sequence
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (password.charAt(i+1) == password.charAt(i)) // Checks if a two characters are the same in a sequence
				throw new InvalidSequenceException();
		}
		return true;
	}

}
