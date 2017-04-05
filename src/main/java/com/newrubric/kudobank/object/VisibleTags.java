package com.newrubric.kudobank.object;

import java.util.List;

public class VisibleTags {
	List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "VisibleTags [tags=" + tags + "]";
	}
	
	
}
