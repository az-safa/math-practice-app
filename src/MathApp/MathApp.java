package MathApp;

import java.util.Random;
import java.util.Scanner;

public class MathApp {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		for (int i = 0; i < 10; i++) {
			//Set up random numbers
			int num1 = rand.nextInt(10) + 1;
			int num2 = rand.nextInt(10) + 1;
			
			//operation setup
			int operation = rand.nextInt(4);
			int ans = 0;
			
			//addition
			if (operation == 3) {
				System.out.println(num1 + " + " + num2 + " = ?");
				ans = num1 + num2;
			
			//subtraction (larger number first, no negatives)
			} else if (operation == 2) {
				if (num1 > num2) {
					System.out.println(num1 + " - " + num2 + " = ?");
					ans = num1 - num2;
				} else {
					System.out.println(num2 + " - " + num1 + " = ?");
					ans = num2 - num1;
				}
				
			//multiplication
			} else if (operation == 1) {
				System.out.println(num1 + " * " + num2 + " = ?");
				ans = num1 * num2;
				
			//division
			} else if (operation == 0) {
				ans = rand.nextInt(10) + 1;
				num1 = num2 * ans;
				System.out.println(num1 + " / " + num2 + " = ?");
			}

			int userAns = Integer.valueOf(scanner.nextLine());
			if (userAns == ans) {
				System.out.println("Correct.");
				score++;
			} else {
				System.out.println("Incorrect. The correct answer was: " + ans);
			}
		}
		System.out.println("You finished 10 questions! Your score was " + score + "/10.");
	}
}
