package com.newrubric.kudobank.model;

import java.util.List;

import com.newrubric.kudobank.object.GradeApplicability;
import com.newrubric.kudobank.object.QuestionAuthor;
import com.newrubric.kudobank.object.Tag;
import com.newrubric.kudobank.object.Status;


public abstract class BaseQuestionModel {
	List<Tag> visibleTags;
	List<Tag> hiddenTags;
	QuestionAuthor createdBy;
	String difficultyLevel = "Medium";
	int flagCount = 0;
	List<GradeApplicability> grades;
	String questionText = "";
	String nrQuestionId = "";
	String questionImagesUrl = "";
	int questionViews = 0;
	List<String>  subjectApplicable;
	String questionType = "questionMCQ";
	int upvotes = 0;
	int usageCount = 0;
	String pathToCreateQuestionPage =  "/feed";
	

	//Added 30 Mar Krithika
	int reviewRequests =0;
	int reviewAccepts =0;
	Boolean starred = false;
	Status status;
	//Changes complete
	
	public List<Tag> getVisibleTags() {
		return visibleTags;
	}
	public void setVisibleTags(List<Tag> visibleTags) {
		this.visibleTags = visibleTags;
	}
	public List<Tag> getHiddenTags() {
		return hiddenTags;
	}
	public void setHiddenTags(List<Tag> hiddenTags) {
		this.hiddenTags = hiddenTags;
	}
	public QuestionAuthor getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(QuestionAuthor createdBy) {
		this.createdBy = createdBy;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public int getFlagCount() {
		return flagCount;
	}
	public void setFlagCount(int flagCount) {
		this.flagCount = flagCount;
	}
	public List<GradeApplicability> getGrades() {
		return grades;
	}
	public void setGrades(List<GradeApplicability> grades) {
		this.grades = grades;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getNrQuestionId() {
		return nrQuestionId;
	}
	public void setNrQuestionId(String nrQuestionId) {
		this.nrQuestionId = nrQuestionId;
	}
	public String getQuestionImagesUrl() {
		return questionImagesUrl;
	}
	public void setQuestionImagesUrl(String questionImagesUrl) {
		this.questionImagesUrl = questionImagesUrl;
	}
	public int getQuestionViews() {
		return questionViews;
	}
	public void setQuestionViews(int questionViews) {
		this.questionViews = questionViews;
	}
	public List<String> getSubjectApplicable() {
		return subjectApplicable;
	}
	public void setSubjectApplicable(List<String> subjectApplicable) {
		this.subjectApplicable = subjectApplicable;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public int getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}
	public int getUsageCount() {
		return usageCount;
	}
	public void setUsageCount(int usageCount) {
		this.usageCount = usageCount;
	}
	public String getPathToCreateQuestionPage() {
		return pathToCreateQuestionPage;
	}
	public void setPathToCreateQuestionPage(String pathToCreateQuestionPage) {
		this.pathToCreateQuestionPage = pathToCreateQuestionPage;
	}

// Added 30 Mar Krithika
	public int getReviewRequests() {
		return reviewRequests;
	}
	public void setReviewRequests(int reviewRequests) {
		this.reviewRequests = reviewRequests;
	}
	public int getReviewAccepts() {
		return reviewAccepts;
	}
	public void setReviewAccepts(int reviewAccepts) {
		this.reviewAccepts = reviewAccepts;
	}
	public boolean getStarred() {
		return starred;
	}
	public void setStarred(boolean starred) {
		this.starred = starred;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}	
// Changes complete
	@Override
	public String toString() {
		return "BaseQuestionObject [visibleTags=" + visibleTags + ", hiddenTags=" + hiddenTags + ", createdBy="
				+ createdBy + ", difficultyLevel=" + difficultyLevel + ", flagCount=" + flagCount + ", grades=" + grades
				+ ", questionText=" + questionText + ", nrQuestionId=" + nrQuestionId + ", questionImagesUrl="
				+ questionImagesUrl + ", questionViews=" + questionViews + ", subjectApplicable=" + subjectApplicable
				+ ", questionType=" + questionType + ", upvotes=" + upvotes + ", usageCount=" + usageCount
				+ ", pathToCreateQuestionPage=" + pathToCreateQuestionPage 
				+ ", reviewRequests=" + reviewRequests + ", reviewAccepts=" + reviewAccepts 
				+ ", starred=" + starred + ", status=" + status + "]";
	}


}
