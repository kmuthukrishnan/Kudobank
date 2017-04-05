package com.newrubric.kudobank.object;

public class AnswerKey {
	private Integer keyMarks;
	private Integer keyOrderNumber;
	private String keyType;
	private String keyValue;
	private String keyImage;
	
	public Integer getKeyMarks() {
		return keyMarks;
	}
	public void setKeyMarks(Integer keyMarks) {
		this.keyMarks = keyMarks;
	}
	public Integer getKeyOrderNumber() {
		return keyOrderNumber;
	}
	public void setKeyOrderNumber(Integer keyOrderNumber) {
		this.keyOrderNumber = keyOrderNumber;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getKeyImage() {
		return keyImage;
	}
	public void setKeyImage(String keyImage) {
		this.keyImage = keyImage;
	}
	@Override
	public String toString() {
		return "AnswerKey [keyMarks=" + keyMarks + ", keyOrderNumber=" + keyOrderNumber + ", keyType=" + keyType
				+ ", keyValue=" + keyValue + ", keyImage=" + keyImage + "]";
	}
	
	
}
