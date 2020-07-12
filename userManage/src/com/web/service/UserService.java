package com.web.service;


import com.web.domain.User;

public interface UserService {

	void regist(User user) throws Exception;

	User active(String code) throws Exception;

	User loign(String username, String password) throws Exception;

	void deleteUser(String uid) throws Exception;

	void addUser(User user) throws Exception;

	void updateState(String uid) throws Exception;

	User getUserByUid(String uid) throws Exception;

	void updateUser(User user) throws Exception;

}
