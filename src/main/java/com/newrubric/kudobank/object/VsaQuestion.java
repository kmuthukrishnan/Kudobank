package com.newrubric.kudobank.object;

public class VsaQuestion  extends BaseQuestionObject{
	private String vsaQuestionCategory ;
	private String correctOption ;
	public String getVsaQuestionCategory() {
		return vsaQuestionCategory;
	}
	public void setVsaQuestionCategory(String vsaQuestionCategory) {
		this.vsaQuestionCategory = vsaQuestionCategory;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	@Override
	public String toString() {
		return "VsaQuestion [vsaQuestionCategory=" + vsaQuestionCategory + ", correctOption=" + correctOption
				+ ", nrQuestionId=" + nrQuestionId + ", questionText=" + questionText + ", questionImageExists="
				+ questionImageExists + ", nrSubskillId=" + nrSubskillId + ", subskillName=" + subskillName
				+ ", nrSuperskillId=" + nrSuperskillId + ", superskillName=" + superskillName + ", nrTopicId="
				+ nrTopicId + ", nrTopicName=" + nrTopicName + ", topicDisplayName=" + topicDisplayName + ", nrLcsaId="
				+ nrLcsaId + ", lcsaName=" + lcsaName + "]";
	}
	
	
}
