package com.company2.socialpolling;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sravya
 * 
 */
@Entity
@Table(name =  "PollCounter")
public class PollCounter {

	@Id
	private int pollId;
	
	private int optionValue;
	
	private int counter;

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

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	

}
