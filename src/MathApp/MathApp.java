package MathApp;

import java.util.Random;
import java.util.Scanner;

public class MathApp {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);

		int score = 0;
		int addMax = 0;
		int addMin = 0;
		int multMax = 0;
		int multMin = 0;
		int opMin = 0;

		System.out.println("Choose Difficulty: 1 = Easy, 2 = Medium, 3 = Hard");
		int difficulty = Integer.valueOf(scanner.nextLine());

		while (difficulty < 1 || difficulty > 3) {
			System.out.println("Please enter 1, 2, or 3.");
			difficulty = Integer.valueOf(scanner.nextLine());
		}

		if (difficulty == 1) {
			addMin = 0;
			addMax = 10;
			opMin = 2;
			System.out.println("Easy Selected.");

		} else if (difficulty == 2) {
			addMin = 0;
			addMax = 100;
			multMin = 1;
			multMax = 12;
			System.out.println("Medium Selected.");

		} else {
			addMin = 50;
			addMax = 1000;
			multMin = 1;
			multMax = 50;
			System.out.println("Hard Selected.");
		}
		
		for (int i = 0; i < 10; i++) {

			int addSub = rand.nextInt(addMax - addMin + 1) + addMin;
			int addSub2 = rand.nextInt(addMax - addMin + 1) + addMin;
			int multDiv = rand.nextInt(multMax - multMin + 1) + multMin;
			int multDiv2 = rand.nextInt(multMax - multMin + 1) + multMin;

			// operation setup
			int operation = rand.nextInt(4 - opMin) + opMin;
			int ans = 0;

			// addition
			if (operation == 3) {
				System.out.println(addSub + " + " + addSub2 + " = ?");
				ans = addSub + addSub2;

				// subtraction (larger number first, no negatives)
			} else if (operation == 2) {
				if (addSub > addSub2) {
					System.out.println(addSub + " - " + addSub2 + " = ?");
					ans = addSub - addSub2;
				} else {
					System.out.println(addSub2 + " - " + addSub + " = ?");
					ans = addSub2 - addSub;
				}

				// multiplication
			} else if (operation == 1) {
				System.out.println(multDiv + " * " + multDiv2 + " = ?");
				ans = multDiv * multDiv2;
				// division
			} else if (operation == 0) {
				ans = rand.nextInt(10) + 1;
				multDiv = multDiv2 * ans;
				System.out.println(multDiv + " / " + multDiv2 + " = ?");
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
