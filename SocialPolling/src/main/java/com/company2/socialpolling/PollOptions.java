package com.company2.socialpolling;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

/**
 * @author Sravya
 *
 * 
 */
@Entity
@Table(name =  "PollOptions")

public class PollOptions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pollOptionId;
	
	private String optionDesc;
	
	private int optionValue;
	
	@ManyToOne
	@JoinColumn(name="pollId")
	private Poll poll;
	
	public Poll getPoll() {
		return poll;
	}

	public void setPoll(int pollId) {
		this.poll = new Poll();
		this.poll.setPollId(pollId);
	}

	public int getPollOptionId()
	{
		return pollOptionId;
	}

	public String getOptionDesc() {
		return optionDesc;
	}

	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}

	public int getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(int optionValue) {
		this.optionValue = optionValue;
	}
	
}
