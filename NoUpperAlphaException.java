

/**
 * This Exception is thrown if the string does not contain an upper case char 
 * 
 * @author Meba Tadesse
 *
 */
public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}