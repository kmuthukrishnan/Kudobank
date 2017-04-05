package com.newrubric.kudobank.object;

public class QnEvaluationKey {
	private String qnEvalKeyId;
	private Integer evalKeyMarks;
	private Integer evalKeySeq;
	private String evalKeyType;
	private String evalKeyTypeDisplayName;
	private String evalKeyTypeId;
	private String evalKeyTypeName;
	private String nrQuestionId;
	public String getQnEvalKeyId() {
		return qnEvalKeyId;
	}
	public void setQnEvalKeyId(String qnEvalKeyId) {
		this.qnEvalKeyId = qnEvalKeyId;
	}
	public Integer getEvalKeyMarks() {
		return evalKeyMarks;
	}
	public void setEvalKeyMarks(Integer evalKeyMarks) {
		this.evalKeyMarks = evalKeyMarks;
	}
	public Integer getEvalKeySeq() {
		return evalKeySeq;
	}
	public void setEvalKeySeq(Integer evalKeySeq) {
		this.evalKeySeq = evalKeySeq;
	}
	public String getEvalKeyType() {
		return evalKeyType;
	}
	public void setEvalKeyType(String evalKeyType) {
		this.evalKeyType = evalKeyType;
	}
	public String getEvalKeyTypeDisplayName() {
		return evalKeyTypeDisplayName;
	}
	public void setEvalKeyTypeDisplayName(String evalKeyTypeDisplayName) {
		this.evalKeyTypeDisplayName = evalKeyTypeDisplayName;
	}
	public String getEvalKeyTypeId() {
		return evalKeyTypeId;
	}
	public void setEvalKeyTypeId(String evalKeyTypeId) {
		this.evalKeyTypeId = evalKeyTypeId;
	}
	public String getEvalKeyTypeName() {
		return evalKeyTypeName;
	}
	public void setEvalKeyTypeName(String evalKeyTypeName) {
		this.evalKeyTypeName = evalKeyTypeName;
	}
	public String getNrQuestionId() {
		return nrQuestionId;
	}
	public void setNrQuestionId(String nrQuestionId) {
		this.nrQuestionId = nrQuestionId;
	}
	@Override
	public String toString() {
		return "QnEvaluationKey [qnEvalKeyId=" + qnEvalKeyId + ", evalKeyMarks=" + evalKeyMarks + ", evalKeySeq="
				+ evalKeySeq + ", evalKeyType=" + evalKeyType + ", evalKeyTypeDisplayName=" + evalKeyTypeDisplayName
				+ ", evalKeyTypeId=" + evalKeyTypeId + ", evalKeyTypeName=" + evalKeyTypeName + ", nrQuestionId="
				+ nrQuestionId + "]";
	}
	
}
