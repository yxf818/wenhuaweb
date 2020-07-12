package com.web.service.impl;


import com.web.constant.Constant;
import com.web.dao.UserDao;
import com.web.domain.User;
import com.web.service.UserService;
import com.web.utils.BeanFactory;


public class UserServiceImpl  implements UserService{
	
	private UserDao ud = (UserDao) BeanFactory.getBean("UserDao");
	/*
	 * 调用dao完成注册
	 * (non-Javadoc)
	 * @see com.web.service.UserService#regist(com.web.domain.User)
	 */
	
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		ud.save(user);
		
		String emailMsg = 
				"恭喜"+user.getName()+": 成功注册成为商城一员,<a href='http://localhost:8080/demo/UserService?method=active&code="+user.getCode()+"'>点此激活</a>";
		
	}

	
	public User active(String code) throws Exception {
		// TODO Auto-generated method stub
		User user =  ud.getByCode(code);
		if(user == null) {
			return null;
		}
		
		user.setState(Constant.USER_IS_ACTIVE);
		user.setCode(null);
		
		ud.update(user);
		
		return user;
	}

	
	public User loign(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		//通过UserDao获取用户名和密码
		return  ud.getByUnameAndPwd(username,password);
		
	}

	
	public void deleteUser(String uid) throws Exception {
		// TODO Auto-generated method stub
		ud.deleteUser(uid);
	}

	
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		ud.save(user);
	}

	
	public void updateState(String uid) throws Exception {
		// TODO Auto-generated method stub
		ud.updateCode(uid);
	}

	
	public User getUserByUid(String uid) throws Exception {
		// TODO Auto-generated method stub
		return ud.getUserByUid(uid);
	}

	
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		ud.updateUser(user);
	}
	
	

}
