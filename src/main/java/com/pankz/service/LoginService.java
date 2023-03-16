package com.pankz.service;

import java.util.HashMap;

import com.pankz.dto.User;

public class LoginService {
	HashMap<String,String> users=new HashMap<String,String>();
	public LoginService() //dummy DB
	{
		users.put("pankz", "Pankaj");
		users.put("ankt","Ankit" );
		users.put("jguru","javaguru");
				
			
		
	}
	//dummy method for authentication---->(Business Service)
	public boolean authenticate(String userId,String password)
	{
		if(password==null || password.trim()=="")
		{
			return false;
		}
		return true;
	}
public User getUserDetails(String userId)
{
	User user=new User();
	user.setUserName(users.get(userId));
	user.setUserId(userId);
	 return user ;
}
}
