package com.newrubric.kudobank.model;

import java.util.List;

import com.newrubric.kudobank.object.AnswerKey;

public class QuestionOpenEndedWithKey  extends BaseQuestionModel{
	private List<AnswerKey> correctAnswer;

	public List<AnswerKey> getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(List<AnswerKey> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "QuestionOpenEndedWithKey [correctAnswer=" + correctAnswer + ", visibleTags=" + visibleTags
				+ ", hiddenTags=" + hiddenTags + ", createdBy=" + createdBy + ", difficultyLevel=" + difficultyLevel
				+ ", flagCount=" + flagCount + ", grades=" + grades + ", questionText=" + questionText
				+ ", nrQuestionId=" + nrQuestionId + ", questionImagesUrl=" + questionImagesUrl + ", questionViews="
				+ questionViews + ", subjectApplicable=" + subjectApplicable + ", questionType=" + questionType
				+ ", upvotes=" + upvotes + ", usageCount=" + usageCount + ", pathToCreateQuestionPage="
				+ pathToCreateQuestionPage + "]";
	}
	
	
}
