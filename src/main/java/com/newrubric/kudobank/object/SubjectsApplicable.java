package com.newrubric.kudobank.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubjectsApplicable {
Set<String> subjects = new TreeSet<String>();

public List<String> getSubjects() {
	return new ArrayList(subjects);
}

public void setSubjects(Set<String> subjects) {
	this.subjects = subjects;
}

@Override
public String toString() {
	return "SubjectsApplicable [subjects=" + subjects + "]";
}


}
