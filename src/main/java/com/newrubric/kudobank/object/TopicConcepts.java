package com.newrubric.kudobank.object;

import java.util.Set;
import java.util.TreeSet;

public class TopicConcepts {
	private String conceptsIncluded1 ;
	private String conceptsIncluded2 ;
	private String conceptsIncluded3 ;
	private String conceptsIncluded4 ;
	private String conceptsIncluded5 ;
	private String conceptsIncluded6 ;
	private String conceptsIncluded7 ;
	private String conceptsIncluded8 ;
	private String conceptsIncluded9 ;
	private String conceptsIncluded10 ;
	private String subject;
	
	public String getConceptsIncluded1() {
		return conceptsIncluded1;
	}
	public void setConceptsIncluded1(String conceptsIncluded1) {
		this.conceptsIncluded1 = conceptsIncluded1;
	}
	public String getConceptsIncluded2() {
		return conceptsIncluded2;
	}
	public void setConceptsIncluded2(String conceptsIncluded2) {
		this.conceptsIncluded2 = conceptsIncluded2;
	}
	public String getConceptsIncluded3() {
		return conceptsIncluded3;
	}
	public void setConceptsIncluded3(String conceptsIncluded3) {
		this.conceptsIncluded3 = conceptsIncluded3;
	}
	public String getConceptsIncluded4() {
		return conceptsIncluded4;
	}
	public void setConceptsIncluded4(String conceptsIncluded4) {
		this.conceptsIncluded4 = conceptsIncluded4;
	}
	public String getConceptsIncluded5() {
		return conceptsIncluded5;
	}
	public void setConceptsIncluded5(String conceptsIncluded5) {
		this.conceptsIncluded5 = conceptsIncluded5;
	}
	public String getConceptsIncluded6() {
		return conceptsIncluded6;
	}
	public void setConceptsIncluded6(String conceptsIncluded6) {
		this.conceptsIncluded6 = conceptsIncluded6;
	}
	public String getConceptsIncluded7() {
		return conceptsIncluded7;
	}
	public void setConceptsIncluded7(String conceptsIncluded7) {
		this.conceptsIncluded7 = conceptsIncluded7;
	}
	public String getConceptsIncluded8() {
		return conceptsIncluded8;
	}
	public void setConceptsIncluded8(String conceptsIncluded8) {
		this.conceptsIncluded8 = conceptsIncluded8;
	}
	public String getConceptsIncluded9() {
		return conceptsIncluded9;
	}
	public void setConceptsIncluded9(String conceptsIncluded9) {
		this.conceptsIncluded9 = conceptsIncluded9;
	}
	public String getConceptsIncluded10() {
		return conceptsIncluded10;
	}
	public void setConceptsIncluded10(String conceptsIncluded10) {
		this.conceptsIncluded10 = conceptsIncluded10;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Set<String> getConceptSet(){
		Set<String> concepts = new TreeSet<String>();
		
		if(!isEmpty(conceptsIncluded1)){
			concepts.add(conceptsIncluded1.trim());
		}
		
		if(!isEmpty(conceptsIncluded2)){
			concepts.add(conceptsIncluded2.trim());
		}
		
		if(!isEmpty(conceptsIncluded3)){
			concepts.add(conceptsIncluded3.trim());
		}
		
		if(!isEmpty(conceptsIncluded4)){
			concepts.add(conceptsIncluded4.trim());
		}
		
		if(!isEmpty(conceptsIncluded5)){
			concepts.add(conceptsIncluded5.trim());
		}		
		
		if(!isEmpty(conceptsIncluded6)){
			concepts.add(conceptsIncluded6.trim());
		}
		
		if(!isEmpty(conceptsIncluded7)){
			concepts.add(conceptsIncluded7.trim());
		}
		
		if(!isEmpty(conceptsIncluded8)){
			concepts.add(conceptsIncluded8.trim());
		}
		
		if(!isEmpty(conceptsIncluded9)){
			concepts.add(conceptsIncluded9.trim());
		}
		
		if(!isEmpty(conceptsIncluded10)){
			concepts.add(conceptsIncluded10.trim());
		}				
		return concepts;
	}
	
	private boolean isEmpty(String data){
		if((null == data)||(data.trim().isEmpty())){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "TopicConcepts [conceptsIncluded1=" + conceptsIncluded1 + ", conceptsIncluded2=" + conceptsIncluded2
				+ ", conceptsIncluded3=" + conceptsIncluded3 + ", conceptsIncluded4=" + conceptsIncluded4
				+ ", conceptsIncluded5=" + conceptsIncluded5 + ", conceptsIncluded6=" + conceptsIncluded6
				+ ", conceptsIncluded7=" + conceptsIncluded7 + ", conceptsIncluded8=" + conceptsIncluded8
				+ ", conceptsIncluded9=" + conceptsIncluded9 + ", conceptsIncluded10=" + conceptsIncluded10 + "]";
	}
	
	
}
