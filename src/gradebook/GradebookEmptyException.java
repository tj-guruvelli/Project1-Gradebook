/*
 * Assignment Name: Project 1
 * @author Teja Guruvelli
 */

package gradebook;


@SuppressWarnings("serial")
public class GradebookEmptyException extends Exception{

	public GradebookEmptyException() {
	}

	public GradebookEmptyException(String message) {
		super(message);
	}

}
