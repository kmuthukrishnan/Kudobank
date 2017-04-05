package com.newrubric.kudobank.object;

public class Status {
	private boolean created;
    // private boolean reviewed;

	public boolean getCreated() {
		return created;
        // return reviewed;
	}
	public void setCreated(boolean created) {
		this.created = created;
        // this.reviewed = !created;
	}

    @Override
	public String toString() {
		return "status [created=" + created + "]";
	}
	
}