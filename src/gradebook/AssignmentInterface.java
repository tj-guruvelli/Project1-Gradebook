

package gradebook;

import java.time.LocalDateTime;

public interface AssignmentInterface {

		 int getScore();
		 void setScore(int tempScore);

		 String getLetter();
		 void setLetter(String c);

		 String getName();
		 void setName(String s);

		 String getDueDate();
		 void setDueDate(String t);
		
		String toString();

}

