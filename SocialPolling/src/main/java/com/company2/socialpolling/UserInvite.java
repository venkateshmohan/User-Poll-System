package com.company2.socialpolling;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@IdClass(UserInvite.class)
public class UserInvite implements Serializable {
		
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 7569207036961909432L;

		public UserInvite() {
			
		}
		public UserInvite(int userId, int pollId,int invite) {
			this.userId = userId;
			this.pollId = pollId;
			this.invite=invite;
			
		}

		@Id
		@NonNull
		@Column(name = "userId")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int userId;
		
		@Id
		@NonNull
		@Column(name = "pollId")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int pollId;
		
		@Column(name = "invite")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int invite;
		
		public int getUserId()
		{
			return userId;
		}
		public int getPollId()
		{
			return pollId;
		}
		public int getInvite()
		{
			return invite;
		}
		
		public void setUserId(int userId)
		{
			this.userId=userId;
		}
		public void setPollId(int pollId)
		{
			this.pollId=pollId;
		}
		public void setInvite(int invite)
		{
			this.invite=invite;
		}
		@Override
		public String toString() {
			return "UserInvite [userId=" + userId + ", pollId=" + pollId + ", invite=" + invite + "]";
		}
		
}
