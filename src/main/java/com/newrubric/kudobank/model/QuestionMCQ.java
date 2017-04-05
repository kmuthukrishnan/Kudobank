package com.newrubric.kudobank.model;

import java.util.List;

import com.newrubric.kudobank.object.AnswerOptions;
import com.newrubric.kudobank.object.QuestionAnswerOption;

public class QuestionMCQ extends BaseQuestionModel{
	
	private AnswerOptions answerOptions;

	private List<QuestionAnswerOption> correctAnswer;

	// Apr 2 Krithika
	private int questionMarks = 1;

	
	
	public AnswerOptions getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(AnswerOptions answerOptions) {
		this.answerOptions = answerOptions;
	}
	
	public List<QuestionAnswerOption> getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(List<QuestionAnswerOption> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	// Apr 2 Krithika
	public int getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	@Override
	public String toString() {
		return "QuestionMCQ [answerOptions=" + answerOptions + ", correctAnswer=" + correctAnswer + ", questionMarks=" + questionMarks + "]";
	}
	
	
	
}
