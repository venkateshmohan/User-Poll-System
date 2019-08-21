package com.company2.socialpolling;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author abi
 *
 * Controller for user Poll
 */
@Controller
@RequestMapping(path = "/pollCounter")
public class PollCounterController {
	
	@Autowired
	private PollCounterRepository pollcounterrepository;
	
	/*@GetMapping(path = "/all")
	public @ResponseBody Iterable<PollCounter> getAllPollCounters(){
		return pollcounterrepository.findAll();
	}*/
	
	
	@RequestMapping(path = "/fetchCount/{pollid}/{optionvalue}")
	public @ResponseBody int getSpecificCounter(@PathVariable("pollid") int pollId,@PathVariable("optionvalue") int optionValue) {
		int val;
		try
		{
			val=pollcounterrepository.findCounterById(pollId, optionValue);
		}
		catch(Exception AopInvocationException)
		{
			val= -1;
		}
		return val;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/initCounter/{pollid}/{optionvalue}")
	public void initCounter(@PathVariable("pollid") int pollId,@PathVariable("optionvalue") int optionValue)
	{	
		pollcounterrepository.initCounterById(pollId, optionValue,1);		

	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/increment/{pollid}/{optionvalue}")
	public void increment(@PathVariable("pollid") int pollId,@PathVariable("optionvalue") int optionValue)
	{
			pollcounterrepository.incrementCounterById(pollId, optionValue);		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/decrement/{pollid}/{optionvalue}")
	public void decrement(@PathVariable("pollid") int pollId,@PathVariable("optionvalue") int optionValue)
	{
		pollcounterrepository.decrementCounterById(pollId, optionValue);
	}
	
			
}