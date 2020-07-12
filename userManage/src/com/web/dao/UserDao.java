package com.web.dao;


import com.web.domain.User;

public interface UserDao {

	void save(User user) throws Exception ;

	User getByCode(String code) throws Exception ;

	void update(User user) throws Exception ;

	User getByUnameAndPwd(String username, String password) throws Exception ;

	void deleteUser(String uid) throws Exception;

	void updateCode(String uid) throws Exception;

	User getUserByUid(String uid) throws Exception;

	void updateUser(User user) throws Exception;


}
