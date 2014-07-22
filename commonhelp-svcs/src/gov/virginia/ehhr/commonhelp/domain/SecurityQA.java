package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class SecurityQA implements Serializable {

	private static final long serialVersionUID = -7636402194291657120L;
	
	private String question;
	private String answer;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
