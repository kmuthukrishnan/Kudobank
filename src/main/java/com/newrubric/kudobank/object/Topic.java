package com.newrubric.kudobank.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Topic {
	private String nrTopicId;
	private String topicName;
	private String topicDisplayName;
	private String contentUnit;
	private String conceptsIncluded1;
	private String conceptsIncluded2;
	private String conceptsIncluded3;
	private String conceptsIncluded4;
	private String conceptsIncluded5;
	private String conceptsIncluded6;
	private String conceptsIncluded7;
	private String conceptsIncluded8;
	private String conceptsIncluded9;
	private String conceptsIncluded10;
	private int applicableForPlaygroup;
	private int applicableForNursery;
	private int applicableForUkg;
	private int applicableForLkg;
	private int applicableForGrade1;
	private int applicableForGrade2;
	private int applicableForGrade3;
	private int applicableForGrade4;
	private int applicableForGrade5;
	private int applicableForGrade6;
	private int applicableForGrade7;
	private int applicableForGrade8;
	private int applicableForGrade9;
	private int applicableForGrade10;
	private int applicableForbbm1;
	private String subjectApplicable1;
	private String subjectApplicable2;

	public String getNrTopicId() {
		return nrTopicId;
	}

	public void setNrTopicId(String nrTopicId) {
		this.nrTopicId = nrTopicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDisplayName() {
		return topicDisplayName;
	}

	public void setTopicDisplayName(String topicDisplayName) {
		this.topicDisplayName = topicDisplayName;
	}

	public String getContentUnit() {
		return contentUnit;
	}

	public void setContentUnit(String contentUnit) {
		this.contentUnit = contentUnit;
	}

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

	public int getApplicableForPlaygroup() {
		return applicableForPlaygroup;
	}

	public void setApplicableForPlaygroup(int applicableForPlaygroup) {
		this.applicableForPlaygroup = applicableForPlaygroup;
	}

	public int getApplicableForNursery() {
		return applicableForNursery;
	}

	public void setApplicableForNursery(int applicableForNursery) {
		this.applicableForNursery = applicableForNursery;
	}

	public int getApplicableForUkg() {
		return applicableForUkg;
	}

	public void setApplicableForUkg(int applicableForUkg) {
		this.applicableForUkg = applicableForUkg;
	}

	public int getApplicableForLkg() {
		return applicableForLkg;
	}

	public void setApplicableForLkg(int applicableForLkg) {
		this.applicableForLkg = applicableForLkg;
	}

	public int getApplicableForGrade1() {
		return applicableForGrade1;
	}

	public void setApplicableForGrade1(int applicableForGrade1) {
		this.applicableForGrade1 = applicableForGrade1;
	}

	public int getApplicableForGrade2() {
		return applicableForGrade2;
	}

	public void setApplicableForGrade2(int applicableForGrade2) {
		this.applicableForGrade2 = applicableForGrade2;
	}

	public int getApplicableForGrade3() {
		return applicableForGrade3;
	}

	public void setApplicableForGrade3(int applicableForGrade3) {
		this.applicableForGrade3 = applicableForGrade3;
	}

	public int getApplicableForGrade4() {
		return applicableForGrade4;
	}

	public void setApplicableForGrade4(int applicableForGrade4) {
		this.applicableForGrade4 = applicableForGrade4;
	}

	public int getApplicableForGrade5() {
		return applicableForGrade5;
	}

	public void setApplicableForGrade5(int applicableForGrade5) {
		this.applicableForGrade5 = applicableForGrade5;
	}

	public int getApplicableForGrade6() {
		return applicableForGrade6;
	}

	public void setApplicableForGrade6(int applicableForGrade6) {
		this.applicableForGrade6 = applicableForGrade6;
	}

	public int getApplicableForGrade7() {
		return applicableForGrade7;
	}

	public void setApplicableForGrade7(int applicableForGrade7) {
		this.applicableForGrade7 = applicableForGrade7;
	}

	public int getApplicableForGrade8() {
		return applicableForGrade8;
	}

	public void setApplicableForGrade8(int applicableForGrade8) {
		this.applicableForGrade8 = applicableForGrade8;
	}

	public int getApplicableForGrade9() {
		return applicableForGrade9;
	}

	public void setApplicableForGrade9(int applicableForGrade9) {
		this.applicableForGrade9 = applicableForGrade9;
	}

	public int getApplicableForGrade10() {
		return applicableForGrade10;
	}

	public void setApplicableForGrade10(int applicableForGrade10) {
		this.applicableForGrade10 = applicableForGrade10;
	}

	public int getApplicableForbbm1() {
		return applicableForbbm1;
	}

	public void setApplicableForbbm1(int applicableForbbm1) {
		this.applicableForbbm1 = applicableForbbm1;
	}

	public String getSubjectApplicable1() {
		return subjectApplicable1;
	}

	public void setSubjectApplicable1(String subjectApplicable1) {
		this.subjectApplicable1 = subjectApplicable1;
	}

	public String getSubjectApplicable2() {
		return subjectApplicable2;
	}

	public void setSubjectApplicable2(String subjectApplicable2) {
		this.subjectApplicable2 = subjectApplicable2;
	}

	@Override
	public String toString() {
		return "Topic [nrTopicId=" + nrTopicId + ", topicName=" + topicName + ", topicDisplayName=" + topicDisplayName
				+ ", contentUnit=" + contentUnit + ", conceptsIncluded1=" + conceptsIncluded1 + ", conceptsIncluded2="
				+ conceptsIncluded2 + ", conceptsIncluded3=" + conceptsIncluded3 + ", conceptsIncluded4="
				+ conceptsIncluded4 + ", conceptsIncluded5=" + conceptsIncluded5 + ", conceptsIncluded6="
				+ conceptsIncluded6 + ", conceptsIncluded7=" + conceptsIncluded7 + ", conceptsIncluded8="
				+ conceptsIncluded8 + ", conceptsIncluded9=" + conceptsIncluded9 + ", conceptsIncluded10="
				+ conceptsIncluded10 + ", applicableForPlaygroup=" + applicableForPlaygroup + ", applicableForNursery="
				+ applicableForNursery + ", applicableForUkg=" + applicableForUkg + ", applicableForLkg="
				+ applicableForLkg + ", applicableForGrade1=" + applicableForGrade1 + ", applicableForGrade2="
				+ applicableForGrade2 + ", applicableForGrade3=" + applicableForGrade3 + ", applicableForGrade4="
				+ applicableForGrade4 + ", applicableForGrade5=" + applicableForGrade5 + ", applicableForGrade6="
				+ applicableForGrade6 + ", applicableForGrade7=" + applicableForGrade7 + ", applicableForGrade8="
				+ applicableForGrade8 + ", applicableForGrade9=" + applicableForGrade9 + ", applicableForGrade10="
				+ applicableForGrade10 + ", applicableForbbm1=" + applicableForbbm1 + ", subjectApplicable1="
				+ subjectApplicable1 + ", subjectApplicable2=" + subjectApplicable2 + "]";
	}

	public Set<String> getConceptSet() {
		Set<String> concepts = new TreeSet<String>();

		if (!isEmpty(conceptsIncluded1)) {
			concepts.add(conceptsIncluded1.trim());
		}

		if (!isEmpty(conceptsIncluded2)) {
			concepts.add(conceptsIncluded2.trim());
		}

		if (!isEmpty(conceptsIncluded3)) {
			concepts.add(conceptsIncluded3.trim());
		}

		if (!isEmpty(conceptsIncluded4)) {
			concepts.add(conceptsIncluded4.trim());
		}

		if (!isEmpty(conceptsIncluded5)) {
			concepts.add(conceptsIncluded5.trim());
		}

		if (!isEmpty(conceptsIncluded6)) {
			concepts.add(conceptsIncluded6.trim());
		}

		if (!isEmpty(conceptsIncluded7)) {
			concepts.add(conceptsIncluded7.trim());
		}

		if (!isEmpty(conceptsIncluded8)) {
			concepts.add(conceptsIncluded8.trim());
		}

		if (!isEmpty(conceptsIncluded9)) {
			concepts.add(conceptsIncluded9.trim());
		}

		if (!isEmpty(conceptsIncluded10)) {
			concepts.add(conceptsIncluded10.trim());
		}
		return concepts;
	}

	private boolean isEmpty(String data) {
		if ((null == data) || (data.trim().isEmpty())) {
			return true;
		}
		return false;
	}

	public List<GradeApplicability> getApplicableGrades() {
		Map<String, Boolean> mapGradesApplicable = new HashMap<String, Boolean>();
		List<GradeApplicability> lGrade = new ArrayList<GradeApplicability>();
		GradeApplicability applicable = null;
		if (applicableForbbm1 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("BBM");
			applicable.setApplicable(true);			
			lGrade.add(applicable);
			
			mapGradesApplicable.put("BBM", true);
		}

		if (applicableForPlaygroup == 1) {
			applicable = new GradeApplicability();
			applicable.setId("PlayGroup");
			applicable.setApplicable(true);			
			lGrade.add(applicable);

			mapGradesApplicable.put("PlayGroup", true);
		}
		;
		if (applicableForNursery == 1) {
			applicable = new GradeApplicability();
			applicable.setId("Nursery");
			applicable.setApplicable(true);			
			lGrade.add(applicable);
			
			mapGradesApplicable.put("Nursery", true);
		}
		;
		if (applicableForUkg == 1) {
			applicable = new GradeApplicability();
			applicable.setId("UKG");
			applicable.setApplicable(true);			
			lGrade.add(applicable);
			
			mapGradesApplicable.put("UKG", true);
		}
		;
		if (applicableForLkg == 1) {
			applicable = new GradeApplicability();
			applicable.setId("LKG");
			applicable.setApplicable(true);			
			lGrade.add(applicable);
						
			mapGradesApplicable.put("LKG", true);
		}
		;
		if (applicableForGrade1 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("G1");
			applicable.setApplicable(true);			
			lGrade.add(applicable);
						
			mapGradesApplicable.put("1", true);
		}
		;
		if (applicableForGrade2 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("G2");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			mapGradesApplicable.put("2", true);
		}
		;
		if (applicableForGrade3 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("G3");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			mapGradesApplicable.put("G3", true);
		}
		;
		if (applicableForGrade4 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("4");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			
			mapGradesApplicable.put("G4", true);
		}
		;
		if (applicableForGrade5 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("5");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			
			mapGradesApplicable.put("G5", true);
		}
		;
		if (applicableForGrade6 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("6");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			
			mapGradesApplicable.put("G6", true);
		}
		;
		if (applicableForGrade7 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("7");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			
			mapGradesApplicable.put("G7", true);
		}
		;
		if (applicableForGrade8 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("8");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			
			mapGradesApplicable.put("G8", true);
		}
		;
		if (applicableForGrade9 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("9");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			
			
			mapGradesApplicable.put("G9", true);
		}
		;
		if (applicableForGrade10 == 1) {
			applicable = new GradeApplicability();
			applicable.setId("10");
			applicable.setApplicable(true);			
			lGrade.add(applicable);			

			mapGradesApplicable.put("G10", true);
		}
		;
		return lGrade;
	}
}
