package com.quiz.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Questions {

	@Id
	private int questionNo;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightOption;
	
	public Questions() {
		
	}
	
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getRightOption() {
		return rightOption;
	}
	public void setRightOption(String rightOption) {
		this.rightOption = rightOption;
	}
	public Questions(int questionNo, String question, String option1, String option2, String option3, String option4, String rightOption) {
		super();
		this.questionNo = questionNo;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightOption = rightOption;
	}
	@Override
	public String toString() {
		return "Questions [questionNo=" + questionNo + ", question=" + question + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", rightOption=" + rightOption + "]";
	}
}
