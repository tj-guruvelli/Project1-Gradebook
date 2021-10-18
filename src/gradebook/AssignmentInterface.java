

package gradebook;

import java.time.LocalDateTime;

public interface AssignmentInterface {

		 int getScore();
		 void setScore(int tempScore);

		 String getLetter();
		 void setLetter(String c);

		 String getName();
		 void setName(String s);

		 LocalDateTime getDueDate();
		 void setDueDate(LocalDateTime t);
		
		String toString();

}

