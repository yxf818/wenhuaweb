package com.web.service;

import java.util.List;

import com.web.domain.AdminUser;
import com.web.domain.User;

public interface AdUserService {

	void addAdmin(AdminUser au) throws Exception;

	List<AdminUser> findAll() throws Exception;

	void deleteById(String adminid) throws Exception;

	AdminUser login(String adminuser, String adminpass) throws Exception;

	List<User> findAllUser() throws Exception;

	void updataAdmin(AdminUser adus) throws Exception;


}
