package gradebook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public static LocalDateTime dueDate;

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Gradebook Manager\n");

		// display the command menu
		displayMenu();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of students to store (20 max students): ");
		int maxStudents = sc.nextInt();
		// RESTRICT HOW MANY STUDENTS NUMBER IS VALID

		// Creating and allocating space for an array with the number of students
		// specified
		ArrayList<AssignmentInterface> studentArray = new ArrayList<AssignmentInterface>(maxStudents);

		// perform 1 or more actions
		int option = 0;

		while (option != 9) {
			// get the input from the user
			System.out.println("Enter option number: ");
			option = sc.nextInt();
			// RESTRICT HOW MANY STUDENTS NUMBER IS VALID
			switch (option) {
			case 1:
				studentArray = addGrades(studentArray);
				break;
			case 2:

				break;
			case 3:
				printGrades(studentArray);
				break;
			case 4:
				printAverage(studentArray);
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			default:
				break;
			}
		}
		sc.close();
		quit();
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

	public static ArrayList<AssignmentInterface> addGrades(ArrayList<AssignmentInterface> studentArray) {
		Scanner sc = new Scanner(System.in);
		int objectType = 0;
		int numofQuestions = 0;
		int tempScore = 0;

		if ((studentArray.size() + 1) > 20) {
			// NEED GRADEBOOK EXCEPTION
			System.out.println("The Gradebook is full");
		} else {
			// get the input from the user about the type of assignment
			while (objectType > 3 || objectType < 1) {
				System.out.println("Enter the type of assignment to add: ");
				System.out.println("1) Quiz");
				System.out.println("2) Program");
				System.out.println("3) Discussion");
				objectType = sc.nextInt();
				// RESTRICT HOW MANY STUDENTS NUMBER IS VALID
			}

			switch (objectType) {
			case 1:
				System.out.println("How many Questions are on the quiz?");
				numofQuestions = Integer.parseInt(sc.nextLine());

				// Assignment name
				System.out.println("Enter assignment name: ");
				String nameStr = sc.nextLine();

				// storing Score from user
				System.out.println("Enter score: ");
				try {
					tempScore = sc.nextInt();
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input! Enter a range between(0-100)");
				}

				// storing Letter from user
				System.out.println("Enter letter grade: ");
				String tempGrade = sc.nextLine();

				// Storing the due date from the user
				System.out.println("Enter the due date for the assignment (mm/dd/yyyy): ");
				String dateDue = sc.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");
				LocalDateTime dateTime = LocalDateTime.parse(dateDue, formatter);

				studentArray.add(new Quiz(numofQuestions, tempScore, tempGrade, nameStr, dateTime));
				break;
			case 2:
				System.out.println("What is the program testing?");
				String tempconceptType = sc.nextLine();

				// Assignment name
				System.out.println("Enter assignment name: ");
				nameStr = sc.nextLine();

				// storing Score from user
				System.out.println("Enter score: ");
				try {
					tempScore = sc.nextInt();
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input! Enter a range between(0-100)");
				}

				// storing Letter from user
				System.out.println("Enter letter grade: ");
				tempGrade = sc.nextLine();

				// Storing the due date from the user
				System.out.println("Enter the due date for the assignment (mm/dd/yyyy): ");
				dateDue = sc.nextLine();
				formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");
				dateTime = LocalDateTime.parse(dateDue, formatter);

				studentArray.add(new Program(tempconceptType, tempScore, tempGrade, nameStr, dateTime));
				break;
			case 3:
				System.out.println("What is the associated reading?");
				String tempReading = sc.nextLine();

				// Assignment name
				System.out.println("Enter assignment name: ");
				nameStr = sc.nextLine();

				// storing Score from user
				System.out.println("Enter score: ");
				try {
					tempScore = sc.nextInt();
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input! Enter a range between(0-100)");
				}

				// storing Letter from user
				System.out.println("Enter letter grade: ");
				tempGrade = sc.nextLine();

				// Storing the due date from the user
				System.out.println("Enter the due date for the assignment (mm/dd/yyyy): ");
				dateDue = sc.nextLine();
				formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");
				dateTime = LocalDateTime.parse(dateDue, formatter);

				studentArray.add(new Discussion(tempReading, tempScore, tempGrade, nameStr, dateTime));
				break;
			}
		}
		sc.close();
		return studentArray;
	}

	public static void printGrades(ArrayList<AssignmentInterface> studentArray) {
		int printedScore = 0;
		for (int i = 0; i < studentArray.size(); i++) {
			printedScore = studentArray.getScore();
			System.out.println(printedScore);
		}

	}

	public static void printAverage(ArrayList<AssignmentInterface> studentArray) {
		double sum = 0.0;
		for (int i = 0; i < studentArray.size(); i++) {
			sum += studentArray.getScore();
		}
		double average = sum / studentArray.size();
		System.out.println(average);
	}

	/*
	 * + removeGrade(string name): int array + printMinMax(int array): void
	 */

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

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime t) {
		dueDate = t;
	}

}
