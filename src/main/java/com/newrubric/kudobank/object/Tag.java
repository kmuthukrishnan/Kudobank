package com.newrubric.kudobank.object;

public class Tag {
	private String tagType;
	private String value;
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Tag [tagType=" + tagType + ", value=" + value + "]";
	}
	
	
}
