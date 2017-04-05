package com.newrubric.kudobank.object;

// import java.util.ArrayList;
import java.util.List;

public class QuestionStatus {
	private List<Status> questionStatus;

	public List<Status> getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(List<Status> questionStatus) {
		this.questionStatus = questionStatus;
	}

	@Override
	public String toString() {
		return "QuestionStatus [questionStatus=" + questionStatus + "]";
	}


}