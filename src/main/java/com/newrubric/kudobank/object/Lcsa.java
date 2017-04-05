package com.newrubric.kudobank.object;

public class Lcsa {
	private String nrLcsaId ;
	private String lcsaName ;
	private String lcsaDisplayName ;
	private String subskillName ;
	private String superskillName ;
	private String tagSubject;
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
	public String getLcsaDisplayName() {
		return lcsaDisplayName;
	}
	public void setLcsaDisplayName(String lcsaDisplayName) {
		this.lcsaDisplayName = lcsaDisplayName;
	}
	public String getSubskillName() {
		return subskillName;
	}
	public void setSubskillName(String subskillName) {
		this.subskillName = subskillName;
	}
	public String getSuperskillName() {
		return superskillName;
	}
	public void setSuperskillName(String superskillName) {
		this.superskillName = superskillName;
	}
	
	public String getTagSubject() {
		return tagSubject;
	}
	public void setTagSubject(String tagSubject) {
		this.tagSubject = tagSubject;
	}
	@Override
	public String toString() {
		return "Lcsa [nrLcsaId=" + nrLcsaId + ", lcsaName=" + lcsaName + ", lcsaDisplayName=" + lcsaDisplayName
				+ ", subskillName=" + subskillName + ", superskillName=" + superskillName + "]";
	}
	
}
