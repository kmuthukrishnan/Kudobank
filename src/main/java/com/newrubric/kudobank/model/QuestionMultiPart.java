package com.newrubric.kudobank.model;

import java.util.List;

public class QuestionMultiPart extends BaseQuestionModel{
	private List<BaseQuestionModel> questions ;

	public List<BaseQuestionModel> getQuestions() {
		return questions;
	}

	public void setQuestions(List<BaseQuestionModel> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuestionMultiPart [questions=" + questions + "]";
	}

	
}
