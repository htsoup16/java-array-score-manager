//	Miriam Rose, mrose16, CIS 340, MP1

import java.util.Scanner;

public class MP1 {
	
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numOfScores = 0;
		double[][] studentScores;
		String[] studentNames;
		
		// asks user for input of number of quizzes
		System.out.print("How many scores per student? ");
		numOfScores = Integer.parseInt(scnr.nextLine());
		
		// initializing the arrays
		studentScores = new double[3][numOfScores];
		studentNames = new String[3];
		
		// loop through arrays to ask user for input of student names
		for(int i=0; i< studentNames.length; i++) {
		
			System.out.printf("\nEnter name for student %d: ", i + 1);
			studentNames[i] = scnr.nextLine();
			System.out.printf("\nEntering scores for %s\n", studentNames[i]);
			// calls method to put scores into array
			studentScores[i] = populateScores(studentScores[i]);
		}	
		
		// brings up menu
		System.out.println();
		showMenu(studentScores, studentNames);
	
	}
	// method that asks user to input scores and stores them in the arrays
	private static double[] populateScores(double[] scores) {
		
		for (int i=0; i<scores.length; i++) {
			System.out.printf("Quiz %d: ", i + 1);
			scores[i] = Double.parseDouble(scnr.nextLine());
		}
		return scores;
		
	}
	
	// method for calculating class average
	private static void classAverage(double[][] scores) {
		
		double total = 0;
		double average = 0;
		int count = 0;
		// loops through the arrays and gets total of all scores
		// also counts number of scores
		for (int i=0; i<scores.length; i++) {
		
			for (int j=0; j < scores[i].length; j++) {
				total += scores[i][j];
				count += 1;
			}	
		}
		// calculation of average and print out
		average = total / count;
		System.out.printf("Class average for all quizzes is %.2f ", average);
	}
	
	// method for calculating student quiz average
	private static void studentAverage(double[][] scores, String[] names) {
	
		String name = "";
		double total = 0;
		double average = 0;
		int flag = 0;
		
		// asks user which student to calculate average for
		System.out.println("\nCalculating average by student.");
		System.out.print("\nEnter student name: ");
		name = scnr.nextLine();
		
		// loop through arrays to find correct student name
		for ( int i=0; i<names.length; i++) {
			if ( name.equalsIgnoreCase(names[i])) {
				System.out.printf("%s's scores are: ", name);
				flag = 1;
				// loop through the arrays to get total of selected student's scores
				for ( int j=0; j<scores[i].length; j++ ) {
					total += scores[i][j];
					System.out.printf("%.2f ", scores[i][j]);
				}
			}
		}
		
		// error message that prints out if wrong student name is entered
		if (flag != 1) {
			System.out.println("Student not found.");
		}
		// calculates the average for selected student and prints out
		else {
			average = total / scores[0].length;
			System.out.printf("\n%s's average is %.2f", name, average);
		}
	}
	// method for calculating a quizzes average for all students
	private static void quizAverage(double[][] scores) {
		
		int quizNum = 0;
		double total = 0;
		double average = 0;
		
		// asks the user which quiz they would like to get average for
		System.out.println("\nCalculating average by Quiz Number");
		System.out.print("Enter Quiz number: ");
		quizNum = Integer.parseInt(scnr.nextLine());
		
		// loop through array to get total of scores for selected quiz
		for ( int i=0; i<scores.length; i++) {
			total += scores[i][quizNum - 1];
		}
		// calculates the average for selected quiz and prints out
		average = total / scores.length;
		System.out.printf("\nQuiz %d average is %.2f", quizNum, average);
	}
	
	// method that shows the user the menu for selecting average calculation
	private static void showMenu(double[][] scores, String[] names) {
		
		String input = "";
		
		// loop that asks user to select which calculation option they want
		do { 
		System.out.println("\t\tMenu\n1. Class Average\n2. Student Average\n3. Quiz Average");
		System.out.print("\nEnter choice number, or x to exit: ");
		input = scnr.nextLine();
		
		// if statements to call the correct method based off user input from menu
		if (input.equals("1")) {
			classAverage(scores);
		}
		else if (input.equals("2")) {
			studentAverage(scores, names);
		}
		else if (input.equals("3")) {
			quizAverage(scores);
		}
		
		// closes the program when x is entered
		System.out.print("\n\n\n\n\n\n");
		} while (!input.equalsIgnoreCase("x"));
		
		System.exit(0);
	
	}
}