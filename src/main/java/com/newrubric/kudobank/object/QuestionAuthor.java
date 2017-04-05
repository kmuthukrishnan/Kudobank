package com.newrubric.kudobank.object;

public class QuestionAuthor {
	private String userName;
	private String userImageUrl;
	private int followerNum= 0;
	private String userLevel = "Editor";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImageUrl() {
		return userImageUrl;
	}
	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}
	public int getFollowerNum() {
		return followerNum;
	}
	public void setFollowerNum(int followerNum) {
		this.followerNum = followerNum;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	@Override
	public String toString() {
		return "QuestionAuthor [userName=" + userName + ", userImageUrl=" + userImageUrl + ", followerNum="
				+ followerNum + ", userLevel=" + userLevel + "]";
	}
	
}
