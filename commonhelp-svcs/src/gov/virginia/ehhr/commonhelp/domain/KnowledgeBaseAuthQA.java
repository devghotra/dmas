package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.List;

public class KnowledgeBaseAuthQA implements Serializable {

	private static final long serialVersionUID = 7494678977697349340L;
	
	
	private String question;
	private String correctAnswer;
	private List<String> answerOptions;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public List<String> getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}
	
}
