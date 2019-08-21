package com.company2.socialpolling;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp; //Needed for accessing datetime mysql variables- createdAt and ExpiryDate

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sravya
 * 
 */
@Entity
@Table(name = "Poll")
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pollId;

	@Column(name = "pollDesc")
	private String description;

	private String createdAt;
	
	private String expiryDate;

	private String createdBy;

	private int createdById;

	private String targetUsers;

	

	@Column(name = "isActive", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;

	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserPoll> userpolls = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "createdById", insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User postOwner;

	public List<UserPoll> getUserpolls() {
		return userpolls;
	}

	public void setUserpolls(List<UserPoll> userpolls) {
		this.userpolls = userpolls;
	}

	public User getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(User postOwner) {
		this.postOwner = postOwner;
	}

	public int getPollId() {
		return pollId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getCreatedById() {
		return createdById;
	}

	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setPollId(int pollId) {
		this.pollId = pollId;

	}
	
	public String getTargetUsers() {
		return targetUsers;
	}

	public void setTargetUsers(String targetUsers) {
		this.targetUsers = targetUsers;
	}

}
