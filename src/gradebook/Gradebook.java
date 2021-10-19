/*
 * Assignment Name: Project 1
 * @author Teja Guruvelli
 */

package gradebook;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Gradebook implements AssignmentInterface {

	// Variables
	public static String conceptType;
	public static String correspondReading;
	public static int numQuestions;

	public static int score;
	public static String name;
	public static String letter;
	public static String dueDate;

	public static void main(String[] args) {

		// Global Variable
		int counter = 0;

		// display a welcome message
		System.out.println("Welcome to the Gradebook Manager\n");

		Scanner sc = new Scanner(System.in);
		int maxStudents = 10;

		System.out.println("Enter number of students to store (20 max students): ");
		boolean checkInput = false;
		while (maxStudents < 0 || maxStudents >= 20 || !checkInput) {

			try {
				maxStudents = Integer.valueOf(sc.nextLine());
				if (maxStudents > 20 || maxStudents < 0) {
					System.out.println("Invalid Input! Enter a range between(0-20) ");
					continue;
				}
				checkInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input! Enter a range between(0-20) ");
			}
		}
		// RESTRICT HOW MANY STUDENTS NUMBER IS VALID

		// Creating and allocating space for an array with the number of students
		// specified
		ArrayList<AssignmentInterface> studentArray = new ArrayList<AssignmentInterface>(maxStudents);

		// perform 1 or more actions
		int option = 0;

		while (option != 9) {
			// get the input from the user
			// display the command menu
			displayMenu();
			System.out.println("Enter option number: ");
			option = Integer.parseInt(sc.nextLine());
			// RESTRICT HOW MANY STUDENTS NUMBER IS VALID
			switch (option) {
			case 1:
				studentArray = addGrades(studentArray, counter);
				break;
			case 2:
				studentArray = removeGrade(studentArray, counter);
				break;
			case 3:
				printGrades(studentArray);
				break;
			case 4:
				printAverage(studentArray);
				break;
			case 5:
				printMinMax(studentArray);
				break;
			case 6:
				Quiz q = new Quiz();
				q.printQuizQuesAverage(studentArray);
				break;
			case 7:
				Discussion d = new Discussion();
				d.printCorrespondReadings(studentArray);
				break;
			case 8:
				Program p = new Program();
				p.printProgramConcepts(studentArray);
				break;
			}
		}

		quit();
		sc.close();
	}

	public static void displayMenu() {
		System.out.println("GRADEBOOK MENU");
		System.out.println("1) Add Grade");
		System.out.println("2) Remove Grade");
		System.out.println("3) Print Grades");
		System.out.println("4) Print Average");
		System.out.println("5) Print Highest/Lowest Grade");
		System.out.println("6) Print Print Quiz Question Average");
		System.out.println("7) Print Discussion Associated Readings");
		System.out.println("8) Print Program Concepts");
		System.out.println("9) Quit\n");

	}

	public static int updatePos(int h) {
		h++;
		return h;
	}

	public static int updateNeg(int h) {
		h--;
		return h;
	}

	public static ArrayList<AssignmentInterface> addGrades(ArrayList<AssignmentInterface> studentArray, int counter) {
		Scanner sc = new Scanner(System.in);
		int objectType = 0;
		int numofQuestions;
		int tempScore = 0;

		if ((studentArray.size() + 1) > 20) {
			// NEED GRADEBOOK EXCEPTION
			System.out.println("The Gradebook is full");
		} else {
			// get the input from the user about the type of assignment
			while (objectType > 3 || objectType < 1) {

				System.out.println("1) Quiz");
				System.out.println("2) Program");
				System.out.println("3) Discussion");
				System.out.println("Choose the assignment number to add: ");
				objectType = Integer.parseInt(sc.nextLine());
				// RESTRICT HOW MANY STUDENTS NUMBER IS VALID
			}

			// Assignment name
			System.out.println("Enter assignment name: ");
			String nameStr = sc.nextLine();

			boolean checkInput = false;
			// storing Score from user
			System.out.println("Enter score: ");
			while (!checkInput) {
				try {
					tempScore = Integer.valueOf(sc.nextLine());
					checkInput = true;
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input! Enter a range between(0-100) ");
				}
			}

			String tempGrade;
			// calculates Letter Grade
			if (score >= 90) {
				tempGrade = "A";
			} else if (score >= 80) {
				tempGrade = "B";
			} else if (score >= 70) {
				tempGrade = "C";
			} else if (score >= 60) {
				tempGrade = "D";
			} else {
				tempGrade = "F";
			}

			// Storing the due date from the user
			System.out.println("Enter the due date for the assignment (mm/dd/yyyy): ");
			String dateDue = sc.nextLine();

			switch (objectType) {
			case 1:
				System.out.println("How many Questions are on the quiz: ");
				numofQuestions = Integer.parseInt(sc.nextLine());

				studentArray.add(new Quiz(numofQuestions, tempScore, tempGrade, nameStr, dateDue));
				break;
			case 2:
				System.out.println("What is the program testing: ");
				String tempconceptType = sc.nextLine();

				studentArray.add(new Program(tempconceptType, tempScore, tempGrade, nameStr, dateDue));
				break;
			case 3:
				System.out.println("What is the associated reading?");
				String tempReading = sc.nextLine();

				studentArray.add(new Discussion(tempReading, tempScore, tempGrade, nameStr, dateDue));
				break;
			}
		}
		counter = updatePos(counter);
		return studentArray;
	}

	public static ArrayList<AssignmentInterface> removeGrade(ArrayList<AssignmentInterface> studentArray, int counter) {
		// if GradeBook empty exception
		try {
			if (counter == 0) {
				throw new GradebookEmptyException();
			}
		} catch (GradebookEmptyException e) {
			e.printStackTrace();
			System.out.println("The Gradebook is Empty");
			return studentArray;
		}

		Scanner sc = new Scanner(System.in);

		// Print out the contents of the list
		String contents;
		System.out.println("Grades: ");
		for (int i = 0; i < studentArray.size(); i++) {
			contents = studentArray.get(i).toString();
			System.out.println(contents);
		}

		// If InvalidGrade Exception
		boolean checkInput = false;
		while (!checkInput) {
			try {
				System.out.println("Enter Score to remove: ");
				int removeScore = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < studentArray.size(); i++) {
					if (studentArray.get(i).getScore() == removeScore) {
						checkInput = true;
					}
				}
				if (checkInput == false) {
					throw new InvalidGradeException();
				}

				for (int i = 0; i < studentArray.size(); i++) {
					if (studentArray.get(i).getScore() == removeScore)
						studentArray.remove(i);
				}

			} catch (InvalidGradeException e) {
				e.printStackTrace();
				System.out.println("The grade does not exist in the gradebook");
				return studentArray;
			}

		}

		counter = updateNeg(counter);
		return studentArray;

	}

	public static void printGrades(ArrayList<AssignmentInterface> studentArray) {
		int printedScore = 0;
		System.out.println("Grades: ");
		for (int i = 0; i < studentArray.size(); i++) {
			printedScore = studentArray.get(i).getScore();
			System.out.println(printedScore);
		}

	}

	public static void printAverage(ArrayList<AssignmentInterface> studentArray) {
		double sum = 0.0;
		for (int i = 0; i < studentArray.size(); i++) {
			sum += studentArray.get(i).getScore();
		}
		double average = sum / studentArray.size();
		BigDecimal bd = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP);
		double fixedAverage = bd.doubleValue();
		System.out.println("Average: " + fixedAverage);
	}

	public static void printMinMax(ArrayList<AssignmentInterface> studentArray) {
		int min = studentArray.get(0).getScore();
		int max = studentArray.get(0).getScore();

		// store the length of the ArrayList in variable n
		int n = studentArray.size();

		// loop to find minimum from ArrayList
		for (int i = 1; i < n; i++) {
			if (studentArray.get(i).getScore() < min) {
				min = studentArray.get(i).getScore();
			}
		}

		// loop to find maximum from ArrayList
		for (int i = 1; i < n; i++) {
			if (studentArray.get(i).getScore() > max) {
				max = studentArray.get(i).getScore();
			}
		}

		// print min and max value of ArrayList
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);

	}

	public static void quit() {
		System.out.println("Bye.\n");
		System.exit(0);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int tempScore) {
		score = tempScore;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String tempLetter) {
		letter = tempLetter;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String t) {
		dueDate = t;
	}

}
