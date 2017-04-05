package com.newrubric.kudobank.object;

public class QuestionImage {
	private String imageName;
	
	private String questionImageId;
	private String questionId;
	private int imageOrder;
	private int isQuestionImage;
	private byte[] image;
	
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getQuestionImageId() {
		return questionImageId;
	}
	public void setQuestionImageId(String questionImageId) {
		this.questionImageId = questionImageId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public int getImageOrder() {
		return imageOrder;
	}
	public void setImageOrder(int imageOrder) {
		this.imageOrder = imageOrder;
	}
	public int getIsQuestionImage() {
		return isQuestionImage;
	}
	public void setIsQuestionImage(int isQuestionImage) {
		this.isQuestionImage = isQuestionImage;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	
}
