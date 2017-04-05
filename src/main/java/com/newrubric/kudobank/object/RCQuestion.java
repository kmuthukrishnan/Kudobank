package com.newrubric.kudobank.object;

public class RCQuestion  extends BaseQuestionObject{

	@Override
	public String toString() {
		return "RCQuestion [nrQuestionId=" + nrQuestionId + ", questionText=" + questionText + ", questionImageExists="
				+ questionImageExists + ", nrSubskillId=" + nrSubskillId + ", subskillName=" + subskillName
				+ ", nrSuperskillId=" + nrSuperskillId + ", superskillName=" + superskillName + ", nrTopicId="
				+ nrTopicId + ", nrTopicName=" + nrTopicName + ", topicDisplayName=" + topicDisplayName + ", nrLcsaId="
				+ nrLcsaId + ", lcsaName=" + lcsaName + "]";
	}
	
}
