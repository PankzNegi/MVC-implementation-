package com.pankz.service;

public class LoginService {
	//dummy method
	public boolean authenticate(String userId,String password)
	{
		if(password==null || password.trim()=="")
		{
			return false;
		}
		return true;
	}

}
