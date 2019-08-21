package com.company2.socialpolling;

import java.util.List;

public class Invite {
	private int userId;
	private Poll poll;
	private List<PollOptions> options;
	public Invite(int userId, Poll poll) {
		super();
		this.userId = userId;
		this.poll = poll;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Poll getPoll() {
		return poll;
	}
	public void setPoll(Poll poll) {
		this.poll = poll;
	}
	public List<PollOptions> getOptions() {
		return options;
	}
	public void setOptions(List<PollOptions> options) {
		this.options = options;
	}

	
}
