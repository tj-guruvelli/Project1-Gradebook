package gradebook;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Quiz implements AssignmentInterface{
	
	// Variables
	private int numQuestions;
	
	private int score;
	private String name;
	private String letter;
	private LocalDateTime dueDate;
		
	// Constructors
	public Quiz()
	{
		numQuestions = 0;
		score = 0;
		letter = "";
		name = "";
	}
		
	public Quiz(int numQuestions, int score, String letter, String name, LocalDateTime dueDate)
	{
		this.numQuestions = numQuestions;
		this.score = score;
		this.letter = letter;
		this.name = name;
		this.dueDate = dueDate;
	}
	
	// Methods
	public int getNumQuestions() {return numQuestions;}
	public void setNumQuestions(int numQuestions) {this.numQuestions = numQuestions;}
	public void printQuizQuesAverage(ArrayList<AssignmentInterface> array)
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

}
