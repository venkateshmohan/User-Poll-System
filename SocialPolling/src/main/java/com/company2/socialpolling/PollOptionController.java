
package com.company2.socialpolling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sravya
 *
 */
@Controller
public class PollOptionController {
	
	@Autowired
	private PollOptionRepository pollOptionRepository;	
	
	@Autowired
	private PollCounterController pcc;
	
	@Autowired
	private PollCounterRepository pcr;
	
	
	@RequestMapping(path = "/poll/{pollId}/options")
	public @ResponseBody Map<Integer, String> getOptionsByPoll(@PathVariable("pollId") int id)
	{	
		Map<Integer, String> hm = new HashMap<>();
		List<PollOptions> po = pollOptionRepository.findByPollId(id);
		for(PollOptions p : po ) {
			hm.put(p.getOptionValue(), p.getOptionDesc());
		}
		return hm;
		
	}
	
	@RequestMapping(path = "/poll/{pollId}/stat")
	public @ResponseBody Map<Integer, Integer> getStat(@PathVariable("pollId") int id)
	{
//		List<PollOptions> po = pollOptionRepository.findByPollId(id);
//		
//		List<Integer> result = new ArrayList<>();
//		
//		for(PollOptions p : po)
//		{	
//			result.add(pcc.getSpecificCounter(id, p.getOptionValue()));
//		}
//		return result;
		
		List<PollOptions> po = pollOptionRepository.findByPollId(id);
		Map<Integer, Integer> hm = new HashMap<>();
		for(PollOptions p : po) {
			int option = p.getOptionValue();
			hm.put(option, pcc.getSpecificCounter(id, option));
		}
		return hm;
	}
	
	@RequestMapping(path = "/poll/{pollId}/options/{id}")
	public @ResponseBody Optional<PollOptions> getOptionById(@PathVariable("id") int id)
	{
		return pollOptionRepository.findById(id);
		
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/poll/{pollId}/options/add")
	public @ResponseBody int addPollOption(@RequestBody PollOptions option, @PathVariable("pollId") int id)
	{
		option.setPoll(id);
		pollOptionRepository.save(option);
		return option.getPollOptionId();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/poll/{pollId}/options/{id}")
	public @ResponseBody void deletePollOption(@PathVariable("id") int id)
	{
		pollOptionRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/poll/{pollId}/options")
	public @ResponseBody void deletePollOptionsByPoll(@PathVariable("pollId") int id)
	{
		pollOptionRepository.deleteByPollId(id);
	}
	
	
	
	
}

