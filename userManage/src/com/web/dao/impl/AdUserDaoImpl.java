package com.web.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.web.dao.AdUserDao;
import com.web.domain.AdminUser;
import com.web.domain.User;
import com.web.utils.DB;

public class AdUserDaoImpl implements AdUserDao {

	private DB db = new DB();
	// 添加管理员
	
	public void addAdmin(AdminUser au) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into admin values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { au.getAdminid(), au.getAdminuser(), au.getAdminpass(), au.getAdminame(), au.getAdminemail(),
				au.getTelephone(), au.getPower(), au.getLogintime(), au.getLoginip(), au.getCreatetime() };
		db.doPstm(sql, params);
		db.closed();
	}

	// 查询所有管理员信息
	
	public List<AdminUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from admin ";
		Object[] params = {};
		db.doPstm(sql, params);
		ResultSet rs = db.getRs();
		List<AdminUser> list = new ArrayList<AdminUser>();
		while(rs.next()) {
			AdminUser aduser = new AdminUser();
			aduser.setAdminame(rs.getString("adminame"));
			aduser.setAdminemail(rs.getString("adminemail"));
			aduser.setAdminid(rs.getString("adminid"));
			aduser.setAdminpass(rs.getString("adminpass"));
			aduser.setCreatetime(rs.getDate("createtime"));
			aduser.setLoginip(rs.getString("loginip"));
			aduser.setLogintime(rs.getDate("logintime"));
			aduser.setTelephone(rs.getString("telephone"));
			aduser.setPower(rs.getInt("power"));
			aduser.setAdminuser(rs.getString("adminuser"));
			list.add(aduser);
		}
		db.closed();
		return list;
	}

	// 通过id删除
	
	public void deleteById(String adminid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from admin where adminid=?";
		Object[] params = { adminid };
		db.doPstm(sql, params);
		db.closed();
	}
	
	/*
	 *  登录验证
	 * @see com.web.dao.AdUserDao#login(java.lang.String, java.lang.String)
	 */
	
	public AdminUser login(String adminuser, String adminpass) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from admin where adminuser = ? and adminpass = ?";
		Object[] params = { adminuser,adminpass };
		db.doPstm(sql, params);
		ResultSet rs = db.getRs();
		
		AdminUser aduser = null;
		if(rs.next()){
			aduser =new AdminUser();
			aduser.setAdminame(rs.getString("adminame"));
			aduser.setAdminemail(rs.getString("adminemail"));
			aduser.setAdminid(rs.getString("adminid"));
			aduser.setAdminpass(rs.getString("adminpass"));
			aduser.setCreatetime(rs.getDate("createtime"));
			aduser.setLoginip(rs.getString("loginip"));
			aduser.setLogintime(rs.getDate("logintime"));
			aduser.setTelephone(rs.getString("telephone"));
			aduser.setPower(rs.getInt("power"));
			aduser.setAdminuser(rs.getString("adminuser"));
		}
		
		return aduser;
	}

	/*
	 * 查询uesr表 (non-Javadoc)
	 * @see com.web.dao.AdUserDao#findAllUser()
	 */
	
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		Object[] params = {  };
		db.doPstm(sql, params);
		ResultSet rs = db.getRs();
		List<User> list = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setUid(rs.getString("uid"));
		
			user.setBirthday(rs.getString("birthday"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			user.setState(rs.getInt("state"));
			user.setTelephone(rs.getString("telephone"));
			user.setUsername(rs.getString("username"));
			list.add(user);
		}
		db.closed();
		return list;
	}

	/*
	 * 更新adminusr表
	 * @see com.web.dao.AdUserDao#updataAdmin(com.web.domain.AdminUser)
	 */
	
	public void updataAdmin(AdminUser adus) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update admin set adminame=?,telephone=?,adminemail=? where adminid=? limit 1";
		Object[] params = { adus.getAdminame(),adus.getTelephone(),adus.getAdminemail(),adus.getAdminid() };
	    db.doPstm(sql, params);
	    db.closed();
	}

}
