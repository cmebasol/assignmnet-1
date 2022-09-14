
/**
 * This Exception is thrown if the string has no digits
 * 
 * @author Meba Tadesse
 *
 */
public class NoDigitException extends Exception {
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
}