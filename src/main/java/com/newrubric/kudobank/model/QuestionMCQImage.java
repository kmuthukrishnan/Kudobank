package com.newrubric.kudobank.model;

import java.util.List;

import com.newrubric.kudobank.object.QnAnswerImageOption;
import com.newrubric.kudobank.object.QuestionAnswerOption;

public class QuestionMCQImage extends BaseQuestionModel{
	
	private List<QnAnswerImageOption> answerImages;
	private List<QuestionAnswerOption> correctAnswer;
	public List<QnAnswerImageOption> getAnswerImages() {
		return answerImages;
	}
	public void setAnswerImages(List<QnAnswerImageOption> answerImages) {
		this.answerImages = answerImages;
	}
	public List<QuestionAnswerOption> getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void setCorrectAnswer(List<QuestionAnswerOption> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
	@Override
	public String toString() {
		return "QuestionMCQImage [answerImages=" + answerImages + ", correctAnswer=" + correctAnswer + ", visibleTags="
				+ visibleTags + ", hiddenTags=" + hiddenTags + ", createdBy=" + createdBy + ", difficultyLevel="
				+ difficultyLevel + ", flagCount=" + flagCount + ", grades=" + grades + ", questionText=" + questionText
				+ ", nrQuestionId=" + nrQuestionId + ", questionImagesUrl=" + questionImagesUrl + ", questionViews="
				+ questionViews + ", subjectApplicable=" + subjectApplicable + ", questionType=" + questionType
				+ ", upvotes=" + upvotes + ", usageCount=" + usageCount + ", pathToCreateQuestionPage="
				+ pathToCreateQuestionPage + "]";
	}	
}
