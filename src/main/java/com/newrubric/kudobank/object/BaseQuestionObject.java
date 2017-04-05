package com.newrubric.kudobank.object;

public abstract class BaseQuestionObject {
	String nrQuestionId ;
	String questionText ;
	int questionImageExists ;
	String nrSubskillId ;
	String subskillName ;
	String nrSuperskillId ;
	String superskillName ;
	String nrTopicId ;
	String nrTopicName ;
	String topicDisplayName ;
	String nrLcsaId ;
	String lcsaName ;
	public String getNrQuestionId() {
		return nrQuestionId;
	}
	public void setNrQuestionId(String nrQuestionId) {
		this.nrQuestionId = nrQuestionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getQuestionImageExists() {
		return questionImageExists;
	}
	public void setQuestionImageExists(int questionImageExists) {
		this.questionImageExists = questionImageExists;
	}
	public String getNrSubskillId() {
		return nrSubskillId;
	}
	public void setNrSubskillId(String nrSubskillId) {
		this.nrSubskillId = nrSubskillId;
	}
	public String getSubskillName() {
		return subskillName;
	}
	public void setSubskillName(String subskillName) {
		this.subskillName = subskillName;
	}
	public String getNrSuperskillId() {
		return nrSuperskillId;
	}
	public void setNrSuperskillId(String nrSuperskillId) {
		this.nrSuperskillId = nrSuperskillId;
	}
	public String getSuperskillName() {
		return superskillName;
	}
	public void setSuperskillName(String superskillName) {
		this.superskillName = superskillName;
	}
	public String getNrTopicId() {
		return nrTopicId;
	}
	public void setNrTopicId(String nrTopicId) {
		this.nrTopicId = nrTopicId;
	}
	public String getNrTopicName() {
		return nrTopicName;
	}
	public void setNrTopicName(String nrTopicName) {
		this.nrTopicName = nrTopicName;
	}
	public String getTopicDisplayName() {
		return topicDisplayName;
	}
	public void setTopicDisplayName(String topicDisplayName) {
		this.topicDisplayName = topicDisplayName;
	}
	public String getNrLcsaId() {
		return nrLcsaId;
	}
	public void setNrLcsaId(String nrLcsaId) {
		this.nrLcsaId = nrLcsaId;
	}
	public String getLcsaName() {
		return lcsaName;
	}
	public void setLcsaName(String lcsaName) {
		this.lcsaName = lcsaName;
	}
	@Override
	public String toString() {
		return "BaseQuestionObject [nrQuestionId=" + nrQuestionId + ", questionText=" + questionText
				+ ", questionImageExists=" + questionImageExists + ", nrSubskillId=" + nrSubskillId + ", subskillName="
				+ subskillName + ", nrSuperskillId=" + nrSuperskillId + ", superskillName=" + superskillName
				+ ", nrTopicId=" + nrTopicId + ", nrTopicName=" + nrTopicName + ", topicDisplayName=" + topicDisplayName
				+ ", nrLcsaId=" + nrLcsaId + ", lcsaName=" + lcsaName + "]";
	}


}
