package com.company2.socialpolling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sravya
 *
 */
@Controller
public class PollController {
	
	@Autowired
	private PollRepository pollrep;
	
	@Autowired
	private PollOptionController poc;
	
	@Autowired
	private UserPollRepository userPollRep;
	
	

	
	@RequestMapping(path = "/poll/all")
	public @ResponseBody Iterable<Poll> getAllPolls()
	{
		return pollrep.findAll();
	}

	@Autowired
	private UserController userContr;
	
//	@RequestMapping(path = "/poll/all")
//	public @ResponseBody Iterable<Poll> getAllPolls()
//	{
//		return pollrep.findAll();
//	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/poll/add")
	public @ResponseBody int addPoll(Poll poll)
	{
		poll.setActive(true);
		poll.setCreatedById(userContr.getUserIdGivenUserName(poll.getCreatedBy()));
		pollrep.save(poll);
		return poll.getPollId();
	}
	//@RequestMapping(method = RequestMethod.PUT, value = "/poll/{id}")
//	public @ResponseBody int modifyPoll(@PathVariable("id") int id)
//	{
//		
//	}
//	@RequestMapping(method = RequestMethod.GET, path = "/poll/{id}")
//	public @ResponseBody Optional<Poll> getPoll(@PathVariable("id") int id)
//	{
//		Optional<Poll> results = pollrep.findById(id);
//		Poll poll = results.get();
//		
//		Timestamp eTime = poll.getExpiryDate();
//		Date current = new java.util.Date();
//		
//		System.out.println("System time:" + current.toString());
//		System.out.println("Expiry time:" + poll.getExpiryDate().toString());
//		
//		if(current.after(eTime)) { //code for expiry check
//			poll.setActive(false);
//			System.out.println("Poll not expired");
//		}
//		else
//			poll.setActive(true);
//		
//		addPoll(poll);
//		
//		return results;
//		
//	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/poll/{id}")
	public @ResponseBody void deletePoll(@PathVariable("id") int pollId)
	{
		poc.deletePollOptionsByPoll(pollId);
		pollrep.deleteById(pollId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "poll/results/{userName}")
	public @ResponseBody List<Poll> getOwnedandParticipatedPolls(@PathVariable("userName") String userName){
		int userId = userContr.getUserIdGivenUserName(userName);
		System.out.println("userId"+userId);
		List<Poll> polls = pollrep.findByCreatedById(userId);
		System.out.println("polls"+polls.size());
		List<UserPoll> part_polls = userPollRep.findByUserId(userId);
		List<Poll> result = new ArrayList<>();
		for(Poll poll : polls) {
			if(isExpired(poll.getExpiryDate()))  // Check if the poll date has expired 
			{
				poll.setActive(false);  // False
				result.add(poll);   // Adding the expired polls that the user owns
			}	
		}
		
		// Extracting the expired polls that the user participates 
		for(UserPoll userPoll : part_polls) {

			if(isExpired(userPoll.getPoll().getExpiryDate())) {
				result.add(userPoll.getPoll());
			}	

		}
		
		return polls;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "user/{username}/pendingpolls")
	public @ResponseBody List<Poll> getUserPendingPolls(@PathVariable("username") String userName){
		int userId = userContr.getUserIdGivenUserName(userName);
		List<Poll> polls = pollrep.findByCreatedById(userId);
		List<Poll> results = new ArrayList<>();
		for(Poll p : polls)
		{
			if(!p.isActive())
				continue;
			if(isExpired(p.getExpiryDate()))
				p.setActive(false);
			else results.add(p);
		}
		return results;
	}
	
	public boolean isExpired(String exDate) // The input is the expiry date
	{
		Calendar c = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		int month = c.get(2)+1;
		sb.append(c.get(1) + "," + month + "," + c.get(5) + "," + c.get(10) + "," + c.get(12));
		String currentDate = sb.toString();
		if(exDate.compareTo(currentDate) <= 0)
			return true;
		return false;
	}
	
}

