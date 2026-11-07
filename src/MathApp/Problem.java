package MathApp;

public class Problem {
	
	private String question;
	private int answer;
	private String topic;
	private int difficulty;
	
	public Problem (String question, int answer, String topic, int difficulty) {
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.difficulty = difficulty;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public int getAnswer() {
		return this.answer;
	}
	
	public String getTopic() {
		return this.topic;
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}
	
	public boolean isCorrect(int studentAnswer) {
		return this.answer == studentAnswer;
	}
	
}
