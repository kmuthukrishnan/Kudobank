package com.newrubric.kudobank.object;

public class McqQuestion extends BaseQuestionObject{

	private int optionImageExists ;
	private String correctOption ;
	private String mcqOption1 ;
	private String mcqOption2 ;
	private String mcqOption3 ;
	private String mcqOption4 ;
	
	public int getOptionImageExists() {
		return optionImageExists;
	}
	public void setOptionImageExists(int optionImageExists) {
		this.optionImageExists = optionImageExists;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public String getMcqOption1() {
		return mcqOption1;
	}
	public void setMcqOption1(String mcqOption1) {
		this.mcqOption1 = mcqOption1;
	}
	public String getMcqOption2() {
		return mcqOption2;
	}
	public void setMcqOption2(String mcqOption2) {
		this.mcqOption2 = mcqOption2;
	}
	public String getMcqOption3() {
		return mcqOption3;
	}
	public void setMcqOption3(String mcqOption3) {
		this.mcqOption3 = mcqOption3;
	}
	public String getMcqOption4() {
		return mcqOption4;
	}
	public void setMcqOption4(String mcqOption4) {
		this.mcqOption4 = mcqOption4;
	}
	@Override
	public String toString() {
		return "McqQuestion [optionImageExists=" + optionImageExists + ", correctOption=" + correctOption
				+ ", mcqOption1=" + mcqOption1 + ", mcqOption2=" + mcqOption2 + ", mcqOption3=" + mcqOption3
				+ ", mcqOption4=" + mcqOption4 + ", nrQuestionId=" + nrQuestionId + ", questionText=" + questionText
				+ ", questionImageExists=" + questionImageExists + ", nrSubskillId=" + nrSubskillId + ", subskillName="
				+ subskillName + ", nrSuperskillId=" + nrSuperskillId + ", superskillName=" + superskillName
				+ ", nrTopicId=" + nrTopicId + ", nrTopicName=" + nrTopicName + ", topicDisplayName=" + topicDisplayName
				+ ", nrLcsaId=" + nrLcsaId + ", lcsaName=" + lcsaName + "]";
	}
	

}
