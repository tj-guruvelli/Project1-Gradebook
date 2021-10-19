/*
 * Assignment Name: Project 1
 * @author Teja Guruvelli
 */

package gradebook;

@SuppressWarnings("serial")
public class InvalidGradeException extends Exception{

	public InvalidGradeException() {
	}

	public InvalidGradeException(String message) {
		super(message);
	}

}
