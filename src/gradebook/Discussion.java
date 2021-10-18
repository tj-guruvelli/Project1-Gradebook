package gradebook;

import java.time.LocalDateTime;

public class Discussion implements AssignmentInterface {

	// Variables
	private String correspondReading;
	private int score;
	private String name;
	private String letter;
	private LocalDateTime dueDate;
	
	// Constructors
	public Discussion()
	{
		correspondReading = "";
		score = 0;
		letter = "";
		name = "";
	}
	
	public Discussion(String correspondReading, int score, String letter, String name, LocalDateTime dueDate)
	{
		this.correspondReading = correspondReading;
		this.score = score;
		this.letter = letter;
		this.name = name;
		this.dueDate = dueDate;
	}
	
	// Methods
	public String getCorrespondReading() {return correspondReading;}
	public void setCorrespondReading(String setRead) {correspondReading = setRead;}

	public void printCorrespondReadings(AssignmentInterface array) {
		System.out.println(array);
	}

	
	public int getScore() {return score;}
	public void setScore(int tempScore) {score = tempScore;}
	public String getLetter() {return letter;}
	public void setLetter(String c) {letter = c;}
	public String getName() {return name;}
	public void setName(String s) {name = s;}
	public LocalDateTime getDueDate() {return dueDate;}
	public void setDueDate(LocalDateTime t) {dueDate = t;}

	
	
	

}
