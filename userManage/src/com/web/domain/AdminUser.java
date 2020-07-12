package com.web.domain;

import java.util.Date;

/*
 * 管理员
 */
public class AdminUser {
	private String adminid; //id
	private String adminuser;//账号
	private String adminpass;//密码
	
	private String adminame;//真实姓名
	private String adminemail;//email
	private String telephone;//联系方式

	private Integer power;//权限
	private Date logintime;//登录时间
	private String loginip;//登录ip地址
	private Date createtime;//创建时间
	
	
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminUser(String adminid, String adminuser, String adminpass, String adminame, String adminemail,
			String telephone, Integer power, Date logintime, String loginip, Date createtime) {
		super();
		this.adminid = adminid;
		this.adminuser = adminuser;
		this.adminpass = adminpass;
		this.adminame = adminame;
		this.adminemail = adminemail;
		this.telephone = telephone;
		this.power = power;
		this.logintime = logintime;
		this.loginip = loginip;
		this.createtime = createtime;
	}

	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminuser() {
		return adminuser;
	}
	public void setAdminuser(String adminuser) {
		this.adminuser = adminuser;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	public String getAdminame() {
		return adminame;
	}
	public void setAdminame(String adminame) {
		this.adminame = adminame;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
}
