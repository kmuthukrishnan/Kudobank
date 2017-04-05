package com.newrubric.kudobank.object;

public class Concept {

	private String concept;
	
	public Concept(){
		
	}
	
	public Concept(String concept1){
		this.concept = concept1;
	}	
	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "Concept [concept=" + concept + "]";
	}
	
}
