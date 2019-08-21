package com.company2.socialpolling;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * @author anurag
 *
 * Controller for users
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private PollRepository pollrep;
	
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userrepository.findAll();
	}
	

	
	@PostMapping(path = "/add")
	public @ResponseBody String addUser(User u) {
		List<User> user = userrepository.findByUserName(u.getUserName());
		List<User> user1 = userrepository.findByPhoneNumber(u.getPhone_number());
		if(user.size() > 0)
			return "username already exists";
		if(user1.size() > 0)
			return "phone number already exists";
		userrepository.save(u);
		return "saved";
	}
	
	@GetMapping(path = "/login")
	public @ResponseBody String retrieveUser(@RequestParam String username, @RequestParam String password){
		try {
			Iterable<User> allUsers = userrepository.findAll();
			if(!utilities.isPhoneNumber(username)) {
				for(User u : allUsers) {
					if(u.getUserName()!=null && u.getPassword()!=null)
					if(u.getUserName().equals(username) && u.getPassword().equals(password)) {
						String s = "";
						if(!u.isActive())
							s+="inactive,";
						else if(u.getIsAdmin() == 1)
							s += "administrator,";
						else
							s += "user,";
						s += u.getUserName();
						return s;
					}
						
				}
			}
		}catch(NullPointerException e) {
			return "";
		}
		
		
		return "";
	}
	
	@GetMapping (path = "/test")
	public @ResponseBody List<User> testControl(@RequestParam String username, @RequestParam String password ) {
		List<User> u;
		 u = userrepository.findByEmailandPassword(username, password);
		return u;
	}
	
	@GetMapping(path = "/delete/{userName}")
	public @ResponseBody String deleteUser(@PathVariable("userName") String userName) {
		List<User> l = userrepository.deleteByUserName(userName);
		if(l.size() == 0)
			return "user does not exist";
		return "deleted";
	}
	
	@RequestMapping(path = "/email/{userName}/{email}")
	public @ResponseBody String sendMail(@PathVariable("userName") String userName,@PathVariable("email") String email) {
	  boolean isActive;
	  String response = null;
	  try
	  {
	    isActive=userrepository.findEmail(userName, email);
	    System.out.println(isActive);
	    if(isActive)
	      response = "Already verified user";
	    else if (!isActive)
	    {	
	      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	      String pwd = RandomStringUtils.random( 8, characters );
	      System.out.println( pwd );
	      
	      Properties props = new Properties();    
	            props.put("mail.smtp.host", "smtp.gmail.com");    
	            props.put("mail.smtp.socketFactory.port", "465");    
	            props.put("mail.smtp.socketFactory.class",    
	                      "javax.net.ssl.SSLSocketFactory");    
	            props.put("mail.smtp.auth", "true");    
	            props.put("mail.smtp.port", "465");    
	            //get Session   
	            
	            String from = "surveygeeks510@gmail.com";
	            String password="rockpapersci";
	            String to = email;
	            
	            Session session = Session.getInstance(props,    
	            new javax.mail.Authenticator() 
	            {    
	             protected PasswordAuthentication getPasswordAuthentication() 
	             {    
	             return new PasswordAuthentication(from,password);  
	             }    
	            });    

	            try 
	            {    
	             MimeMessage message = new MimeMessage(session);    
	             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	             message.setSubject("Social Polling App - Email Verification");    
	             message.setText("Hi "+userName+"!\n\nPlease enter the below code in the app to activate your account\n"+pwd+"\n\nBest,\nSurvey Geek");    
	             Transport.send(message);  
	             userrepository.updateTempPWD(pwd,userName);
	             System.out.println("message sent successfully");    
	            } 
	            catch (MessagingException e) 
	            {
	              throw new RuntimeException(e);
	            }    
	            
	          response=pwd;
	    }
	  }
	  catch(Exception e)
	  {
	    System.out.println(e);
	    response = "No match found";
	  }
	  return response;
	}	

	@RequestMapping(path = "/otp/{userOtp}/{userName}")
	public @ResponseBody String validateOtp(@PathVariable("userOtp") String userOtp,@PathVariable("userName") String userName) 
	{
	  String tempPWD = userrepository.findTempPWD(userName);
	  if (tempPWD.equals(userOtp))
	  {
	    userrepository.updateActiveStatus(userName);
	    return "otp matched";
	  }
	    
	  else
	  {	
	    return "otp mismatch";
	  }		
	}	
	
	/**
	 * 
	 * returns the userid given username
	 * @param userName
	 * @return user id
	 */
	public int getUserIdGivenUserName(String userName) {
		List<User> list = userrepository.findByUserName(userName);
		if(list.size() == 0)
			return -1;
		else {
			//System.out.println(list.get(0));
			return list.get(0).getId();
		}
			
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{username}/getId")
	public @ResponseBody int getUserIdWithUserName(@PathVariable("username") String userName) {
		List<User> list = userrepository.findByUserName(userName);
		if(list.size() == 0)
			return -1;
		else {
			//System.out.println(list.get(0));
			return list.get(0).getId();
		}
			
	}
	
}
