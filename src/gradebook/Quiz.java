/*
 * Assignment Name: Project 1
 * @author Teja Guruvelli
 */

package gradebook;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Quiz implements AssignmentInterface{
	
	// Variables
	private int numQuestions;
	
	private int score;
	private String name;
	private String letter;
	private String dueDate;
		
	// Constructors
	public Quiz()
	{
		numQuestions = 0;
		score = 0;
		letter = "";
		name = "";
	}
		
	public Quiz(int numQuestions, int score, String letter, String name, String dueDate)
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
		System.out.println("Quiz Questions Average: ");
		double sum = 0.0;
		for (int i = 0; i < array.size(); i++) {
			sum += ((Quiz) array.get(i)).getNumQuestions();
		}
		double qAvg = sum / array.size();
		BigDecimal bd = new BigDecimal(qAvg).setScale(2, RoundingMode.HALF_UP);
		double fixedqAvg = bd.doubleValue();
		System.out.println("Average: " + fixedqAvg);
	}


	public int getScore() {return score;}
	public void setScore(int tempScore) {score = tempScore;}
	public String getLetter() {return letter;}
	public void setLetter(String c) {letter = c;}
	public String getName() {return name;}
	public void setName(String s) {name = s;}
	public String getDueDate() {return dueDate;}
	public void setDueDate(String t) {dueDate = t;}
	public String toString()
	{
		//"Name: " + Quiz1, Score: 90, Letter: A, Due: 09/15/21 ...”
		System.out.println("Number of Questions: " + getNumQuestions() + "," +
						   "Name: " + getName() + "," +
						   "Score: " + getScore() + "," +
						   "Letter: " + getLetter() + "," +
						   "Due Date: " + getDueDate());
		return " ";
	}

}
