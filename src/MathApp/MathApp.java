package MathApp;
import java.util.Scanner;

public class MathApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProblemGenerator problemGenerator = new ProblemGenerator();
		int score = 0;
		int difficulty = chooseDifficulty(scanner);

		problemGenerator.setDifficulty(difficulty);
		
		for (int i = 0; i < 10; i++) {
			Problem problem = problemGenerator.generateProblem();
			System.out.print(problem.getQuestion());

			// check answer
			int userAns = Integer.valueOf(scanner.nextLine());
			if (problem.isCorrect(userAns)) {
				System.out.println("Correct.");
				score++;
			} else {
				System.out.println("Incorrect. The correct answer was: " + problem.getAnswer());
			}
		}
		System.out.println("You finished 10 questions! Your score was " + score + "/10.");
	}
	
	public static int chooseDifficulty(Scanner scanner) {
		int difficulty = 0;
		System.out.println("Choose Difficulty: 1 = Easy, 2 = Medium, 3 = Hard");
		difficulty = Integer.valueOf(scanner.nextLine());

		while (difficulty < 1 || difficulty > 3) {
			System.out.println("Please enter 1, 2, or 3.");
			difficulty = Integer.valueOf(scanner.nextLine());
		}
		
		if (difficulty == 1) {
			System.out.println("Easy Selected.");
		} else if (difficulty == 2) {
			System.out.println("Medium Selected.");
		} else {
			System.out.println("Hard Selected.");
		}
		
		return difficulty;
	}
}
