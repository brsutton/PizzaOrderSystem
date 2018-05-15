package com.yash.pos.servicefactory;

import com.yash.pos.serviceimpl.OrderServiceImpl;
import com.yash.pos.serviceimpl.UserServiceImpl;

public class ServiceFactory {

	public static UserServiceImpl getUserServiceImpl(){
		return new UserServiceImpl();
	}

	
	public static   OrderServiceImpl getOrderServiceImpl(){
		return new OrderServiceImpl();
	}
}
	
