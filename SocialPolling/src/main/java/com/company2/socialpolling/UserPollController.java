package com.company2.socialpolling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping(path = "/userpoll")
public class UserPollController {
	
	@Autowired
	private UserPollRepository userpollrepository;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<UserPoll> getAllUserPolls(){
		return userpollrepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public void addUserPoll(@RequestBody UserPoll u)
	{	
		
		userpollrepository.save(u);
	}
	
			
}
