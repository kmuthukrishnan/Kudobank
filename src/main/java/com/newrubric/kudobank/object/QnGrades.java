package com.newrubric.kudobank.object;

import java.util.ArrayList;
import java.util.List;

public class QnGrades {
	private List<GradeApplicability> grades = new ArrayList<GradeApplicability>();

	public List<GradeApplicability> getGrades() {
		return grades;
	}

	public void setGrades(List<GradeApplicability> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "QnGrades [grades=" + grades + "]";
	}


}
