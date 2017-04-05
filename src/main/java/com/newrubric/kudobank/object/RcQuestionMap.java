package com.newrubric.kudobank.object;

public class RcQuestionMap {
	private String nrRcQuestionId;
	private String nrQuestionId;
	private Integer questionOrder;
	private Integer initialMarks;
	private String questionType;
	public String getNrRcQuestionId() {
		return nrRcQuestionId;
	}
	public void setNrRcQuestionId(String nrRcQuestionId) {
		this.nrRcQuestionId = nrRcQuestionId;
	}
	public String getNrQuestionId() {
		return nrQuestionId;
	}
	public void setNrQuestionId(String nrQuestionId) {
		this.nrQuestionId = nrQuestionId;
	}
	public Integer getQuestionOrder() {
		return questionOrder;
	}
	public void setQuestionOrder(Integer questionOrder) {
		this.questionOrder = questionOrder;
	}
	public Integer getInitialMarks() {
		return initialMarks;
	}
	public void setInitialMarks(Integer initialMarks) {
		this.initialMarks = initialMarks;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	@Override
	public String toString() {
		return "RcQuestionMap [nrRcQuestionId=" + nrRcQuestionId + ", nrQuestionId=" + nrQuestionId + ", questionOrder="
				+ questionOrder + ", initialMarks=" + initialMarks + ", questionType=" + questionType + "]";
	}
	
	
}
