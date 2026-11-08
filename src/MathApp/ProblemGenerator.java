package MathApp;
import java.util.Random;

public class ProblemGenerator {
	private int difficulty;
	private Random random;

	public ProblemGenerator() {
		this.random = new Random();
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public Problem generateProblem() {
		int addMin= 0;
		int addMax = 0;
		int opMin = 0;
		int multMin = 0;
		int multMax = 0;
		String topic = "";
		String question = "";
		
		if (difficulty == 1) {
			addMin = 0;
			addMax = 10;
			opMin = 2;

		} else if (difficulty == 2) {
			addMin = 0;
			addMax = 100;
			multMin = 1;
			multMax = 12;

		} else {
			addMin = 50;
			addMax = 1000;
			multMin = 1;
			multMax = 50;
		}

		int addSub = this.random.nextInt(addMax - addMin + 1) + addMin;
		int addSub2 = this.random.nextInt(addMax - addMin + 1) + addMin;
		int multDiv = this.random.nextInt(multMax - multMin + 1) + multMin;
		int multDiv2 = this.random.nextInt(multMax - multMin + 1) + multMin;

		// operation setup
		int operation = this.random.nextInt(4 - opMin) + opMin;
		int answer = 0;

		// addition
		if (operation == 3) {
			topic = "Addition";
			question = addSub + " + " + addSub2 + " = ";
			answer = addSub + addSub2;

			// subtraction (larger number first, no negatives)
		} else if (operation == 2) {
			topic = "Subtraction";
			if (addSub > addSub2) {
				question = addSub + " - " + addSub2 + " = ";
				answer = addSub - addSub2;
			} else {
				question = addSub2 + " - " + addSub + " = ";
				answer = addSub2 - addSub;
			}

			// multiplication
		} else if (operation == 1) {
			topic = "Multiplication";
			question = multDiv + " * " + multDiv2 + " = ";
			answer = multDiv * multDiv2;
			// division
		} else if (operation == 0) {
			topic = "Division";
			answer = this.random.nextInt(10) + 1;
			multDiv = multDiv2 * answer;
			question = multDiv + " / " + multDiv2 + " = ";
		}
		
		return new Problem(question, answer, topic, difficulty);
	}
}
