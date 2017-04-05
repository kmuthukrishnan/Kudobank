package com.newrubric.kudobank.object;

public class QnAnswerImageOption {
	
	private int order;
	private String url;
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "QnAnswerImageOption [order=" + order + ", url=" + url + "]";
	}
	
}
