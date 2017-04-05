package com.newrubric.kudobank.object;

public class SearchTagEntity {
	private String tagType;
	private String tagValue;
	private String tagDisplayValue;
	private String tagSubject;
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getTagValue() {
		return tagValue;
	}
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	public String getTagDisplayValue() {
		return tagDisplayValue;
	}
	public void setTagDisplayValue(String tagDisplayValue) {
		this.tagDisplayValue = tagDisplayValue;
	}
	public String getTagSubject() {
		return tagSubject;
	}
	public void setTagSubject(String tagSubject) {
		this.tagSubject = tagSubject;
	}
	@Override
	public String toString() {
		return "SearchTag [tagType=" + tagType + ", tagValue=" + tagValue + ", tagDisplayValue=" + tagDisplayValue
				+ ", tagSubject=" + tagSubject + "]";
	}
	
}
