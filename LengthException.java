

/**
 * This Exception is thrown if length of password is less than 6 chars.
 * 
 * @author Meba Tadesse
 *
 */
public class LengthException extends Exception {
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}