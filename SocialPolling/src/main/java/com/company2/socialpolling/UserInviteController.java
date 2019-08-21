package com.company2.socialpolling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/userinvite")
public class UserInviteController {
	@Autowired
	private UserInviteRepository userinviterep;

	@Autowired
	private PollRepository pollRepository;
	
	@Autowired
	private PollOptionRepository pollOptionRepository;

	/*
	 * @RequestMapping (method=RequestMethod.POST, path =
	 * "/inviting/{userId}/{pollId}") public @ResponseBody void
	 * postInvite(@PathVariable("userId") int userId,@PathVariable("pollId") int
	 * pollId) { userinviterep.startInvite(userId,pollId,1); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value = "/inviting")
	 * public @ResponseBody void addInvite(UserInvite userinvite) {
	 * userinviterep.save(userinvite); }
	 */
	@PostMapping("/inviting")
	public UserInvite createInvite(@Valid @RequestBody UserInvite userinvite) {
		return userinviterep.save(userinvite);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/invited/{userId}/{pollId}")
	public @ResponseBody void putInvite(@PathVariable("userId") int userId, @PathVariable("pollId") int pollId) {
		userinviterep.updateInvite(userId, pollId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/invites/{userId}")
	public @ResponseBody List<Invite> getInvitesForUser(@PathVariable("userId") int userId) {
		List<UserInvite> userInvites = userinviterep.findByUserId(userId);

		List<Invite> invites = new ArrayList<>();
		if (invites != null) {
			for (UserInvite ui : userInvites) {
				Poll poll = pollRepository.findByIdAndActive(ui.getPollId());
				if (poll != null) {
					Invite invite = new Invite(ui.getUserId(), poll);
					invite.setOptions(pollOptionRepository.findByPollId(ui.getPollId()));
					invites.add(invite);
				}
			}
			
			Collections.sort(invites, (a, b) -> b.getPoll().getPollId() - a.getPoll().getPollId());
		}

		return invites;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/invites/{userId}/{pollId}")
	public @ResponseBody void deleteUserInvite(@PathVariable("userId") int userId, @PathVariable("pollId") int pollId) {
		userinviterep.deactivateInvites(userId, pollId);
	}
}
