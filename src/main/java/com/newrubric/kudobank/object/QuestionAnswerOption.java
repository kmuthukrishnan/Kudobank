package com.newrubric.kudobank.object;

public class QuestionAnswerOption {
	private String optionNumber;
	private String text;
	public String getOptionNumber() {
		return optionNumber;
	}
	public void setOptionNumber(String optionNumber) {
		this.optionNumber = optionNumber;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "QuestionAnswerOption [optionNumber=" + optionNumber + ", text=" + text + "]";
	}
	
}
