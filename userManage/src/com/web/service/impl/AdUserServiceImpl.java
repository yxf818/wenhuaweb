package com.web.service.impl;

import java.util.List;

import com.web.dao.AdUserDao;
import com.web.domain.AdminUser;
import com.web.domain.User;
import com.web.service.AdUserService;
import com.web.utils.BeanFactory;

public class AdUserServiceImpl implements AdUserService {

	AdUserDao aud = (AdUserDao) BeanFactory.getBean("AdUserDao");
	
	public void addAdmin(AdminUser au) throws Exception {
		// TODO Auto-generated method stub
		
		aud.addAdmin(au);
	}

	
	public List<AdminUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		return  aud.findAll();
	}

	
	public void deleteById(String adminid) throws Exception {
		// TODO Auto-generated method stub
		aud.deleteById(adminid);
	}

	
	public AdminUser login(String adminuser, String adminpass) throws Exception {
		// TODO Auto-generated method stub
		return aud.login(adminuser,adminpass);
	}

	
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		return aud.findAllUser();
	}

	
	public void updataAdmin(AdminUser adus) throws Exception {
		// TODO Auto-generated method stub
		aud.updataAdmin(adus);
	}

}
