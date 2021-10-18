package gradebook;

import java.time.LocalDateTime;

public class Program implements AssignmentInterface{
	
	// Variables
	private String conceptType;
	
	private int score;
	private String name;
	private String letter;
	private LocalDateTime dueDate;
			
	// Constructors
	public Program()
	{
		conceptType = "";
		score = 0;
		letter = "";
		name = "";
	}
			
	public Program(String conceptType, int score, String letter, String name, LocalDateTime dueDate)
	{
		this.conceptType = conceptType;
		this.score = score;
		this.letter = letter;
		this.name = name;
		this.dueDate = dueDate;
	}
	
	// Methods
	public String getConceptType() {return conceptType;}
	public void setConceptType(String conceptType) {this.conceptType = conceptType;}
	public void printProgramConcept(AssignmentInterface array)
	{
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
	public String toString()
	{
		//"Name: " + Quiz1, Score: 90, Letter: A, Due: 09/15/21 ...”
		System.out.println("Name: " + name, 
						   "Score: " + score,
						   "Letter: " + letter, 
						   "Due: " + dueDate);
	}

}
