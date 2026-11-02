package MathApp;

import java.util.Random;
import java.util.Scanner;

public class MathApp {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		for (int i = 0; i < 10; i++) {
			int num1 = rand.nextInt(10) + 1;
			int num2 = rand.nextInt(10) + 1;
			int sum = num1 + num2;
			System.out.println(num1 + " + " + num2 + " = ?");
			int userAns = Integer.valueOf(scanner.nextLine());
			if (userAns == sum) {
				System.out.println("Correct.");
				score++;
			} else {
				System.out.println("Incorrect. The correct answer was: " + sum);
			}
		}
		System.out.println("You finished 10 questions! Your score was " + score + "/10.");
	}
}
