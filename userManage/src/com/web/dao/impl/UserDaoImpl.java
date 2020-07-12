package com.web.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.web.constant.Constant;
import com.web.dao.UserDao;
import com.web.domain.User;
import com.web.utils.DB;

public class UserDaoImpl implements UserDao {

	private DB db = new DB();
	/*
	 * 用户注册数据传输
	 * @see com.web.dao.UserDao#save(com.web.domain.User)
	 */
	
	public void save(User user) throws SQLException {
		// TODO Auto-generated method stub
		Object[] params={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
				user.getEmail(),user.getTelephone(),user.getBirthday(),
				user.getSex(),1,user.getCode()};
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		db.doPstm(sql, params);
		db.closed();
	}

	
	/*
	 * 通过code码激活用户
	 * @see com.web.dao.UserDao#getByCode()
	 */
	public User getByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "select * from user where code=? limit 1";
		Object[] params = { code };
		db.doPstm(sql, params);
		ResultSet rs = db.getRs();
		rs.next();
		user.setCode(rs.getString("code"));
		user.setUid(rs.getString("uid"));
		user.setBirthday(rs.getString("birthday"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getString("sex"));
		user.setState(rs.getInt("state"));
		user.setTelephone(rs.getString("telephone"));
		user.setUsername(rs.getString("username"));
		db.closed();
		return user;
	}

	
	/*
	 * 数据更新
	 * @see com.web.dao.UserDao#update(com.web.domain.User)
	 */
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update user set state = ?,code = ? where uid = ?";
		Object[] params = { user.getState(),user.getCode(),user.getUid() };
		db.doPstm(sql, params);
		db.closed();
	}

	/*
	 * 用户登录
	 * @see com.web.dao.UserDao#getByUnameAndPwd(java.lang.String, java.lang.String)
	 */
	
	public User getByUnameAndPwd(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from user where username = ? and password = ? limit 1";
		Object[] params = {  username,password };
		db.doPstm(sql, params);
		ResultSet rs = db.getRs();
		User user = new User();
		while(rs.next()) {

			user.setUid(rs.getString("uid"));
			user.setBirthday(rs.getString("birthday"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			user.setState(rs.getInt("state"));
			user.setTelephone(rs.getString("telephone"));
			user.setUsername(rs.getString("username"));
		}
		db.closed();
		return user;
		
	}

	
	public void deleteUser(String uid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from user where uid = ?";
		Object[] params = { uid };
		db.doPstm(sql, params);
		db.closed();
	}

	
	public void updateCode(String uid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update user set state = ? , code = ? where uid = ?";
		Object[] params = { Constant.USER_IS_ACTIVE,null,uid };
		db.doPstm(sql, params);
		db.closed();
	}

	
	public User getUserByUid(String uid) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "select * from user where uid = ? limit 1";
		Object[] params = { uid };
		db.doPstm(sql, params);
		ResultSet rs = db.getRs();
		rs.next();
		user.setCode(rs.getString("code"));
		user.setBirthday(rs.getString("birthday"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getString("sex"));
		user.setState(rs.getInt("state"));
		user.setTelephone(rs.getString("telephone"));
		user.setUsername(rs.getString("username"));
		db.closed();
		return user;
	}

	
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update user set password = ?,name = ?,birthday = ?,telephone = ? where uid = ?";
		Object[] params = { user.getPassword(),user.getName(),user.getBirthday(),user.getTelephone(),user.getUid() };
		db.doPstm(sql, params);
		db.closed();
	}


}
