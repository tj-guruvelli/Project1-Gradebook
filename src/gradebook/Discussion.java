/*
 * Assignment Name: Project 1
 * @author Teja Guruvelli
 */

package gradebook;

import java.util.ArrayList;

public class Discussion implements AssignmentInterface {

	// Variables
	private String correspondReading;
	private int score;
	private String name;
	private String letter;
	private String dueDate;
	
	// Constructors
	public Discussion()
	{
		correspondReading = "";
		score = 0;
		letter = "";
		name = "";
	}
	
	public Discussion(String correspondReading, int score, String letter, String name, String dueDate)
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

	public void printCorrespondReadings(ArrayList<AssignmentInterface> array) {
		System.out.println("Content of Corresponding Readings: ");
		String content;
		for (int i = 0; i < array.size(); i++) {
			content = ((Discussion) array.get(i)).getCorrespondReading();
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
		System.out.println("Corresponding Reading: " + getCorrespondReading() + "," +
						   "Name: " + getName() + "," +
						   "Score: " + getScore() + "," +
						   "Letter: " + getLetter() + "," +
						   "Due Date: " + getDueDate());
		return " ";
	}

	
	
	

}
