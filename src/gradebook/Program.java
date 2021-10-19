/*
 * Assignment Name: Project 1
 * @author Teja Guruvelli
 */

package gradebook;

import java.util.ArrayList;

public class Program implements AssignmentInterface{
	
	// Variables
	private String conceptType;
	
	private int score;
	private String name;
	private String letter;
	private String dueDate;
			
	// Constructors
	public Program()
	{
		conceptType = "";
		score = 0;
		letter = "";
		name = "";
	}
			
	public Program(String conceptType, int score, String letter, String name, String dueDate)
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
	public void printProgramConcepts(ArrayList<AssignmentInterface> array)
	{
		System.out.println("Content of Program Concepts: ");
		String content;
		for (int i = 0; i < array.size(); i++) {
			content = ((Program) array.get(i)).getConceptType();
			System.out.println(content);
		}
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
		System.out.println("Concept Type: " + getConceptType() + "," +
						   "Name: " + getName() + "," +
						   "Score: " + getScore() + "," +
						   "Letter: " + getLetter() + "," +
						   "Due Date: " + getDueDate());
		return " ";
	}

}
