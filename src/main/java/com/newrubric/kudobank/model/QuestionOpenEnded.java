package com.newrubric.kudobank.model;

import java.util.List;

import com.newrubric.kudobank.object.QuestionAnswerOption;

public class QuestionOpenEnded extends BaseQuestionModel{
	private List<QuestionAnswerOption> correctAnswer;
	public List<QuestionAnswerOption> getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(List<QuestionAnswerOption> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "QuestionOpenEnded [correctAnswer=" + correctAnswer + ", visibleTags=" + visibleTags + ", hiddenTags="
				+ hiddenTags + ", createdBy=" + createdBy + ", difficultyLevel=" + difficultyLevel + ", flagCount="
				+ flagCount + ", grades=" + grades + ", questionText=" + questionText + ", nrQuestionId=" + nrQuestionId
				+ ", questionImagesUrl=" + questionImagesUrl + ", questionViews=" + questionViews
				+ ", subjectApplicable=" + subjectApplicable + ", questionType=" + questionType + ", upvotes=" + upvotes
				+ ", usageCount=" + usageCount + ", pathToCreateQuestionPage=" + pathToCreateQuestionPage + "]";
	}

	
}
