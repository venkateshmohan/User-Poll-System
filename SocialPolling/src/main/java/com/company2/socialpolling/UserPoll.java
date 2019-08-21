package com.company2.socialpolling;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name =  "UserPoll")
public class UserPoll {
	
	private int userId;
	
	@Id
	private int pollId;
	
	private int optionValue;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",insertable=false,updatable=false)
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pollId",insertable=false,updatable=false)
    private Poll poll;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPollId() {
		return pollId;
	}

	public void setPollId(int pollId) {
		this.pollId = pollId;
	}

	public int getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(int optionValue) {
		this.optionValue = optionValue;
	}
	
}
