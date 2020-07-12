package com.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.vcode.utils.VerifyCode;

import com.web.constant.Constant;
import com.web.domain.AdminUser;
import com.web.domain.User;
import com.web.service.AdUserService;
import com.web.service.BaseService;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;
import com.web.utils.BeanFactory;
import com.web.utils.UUIDUtils;

/**
 * Servlet implementation class AdUserServlet
 */
@WebServlet("/aduser")
public class AdUserServlet extends BaseService {
	private static final long serialVersionUID = 1L;
	private UserService us = (UserService) BeanFactory.getBean("UserService");
	private AdUserService ads = (AdUserService) BeanFactory.getBean("AdUserService");

	public String addAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String adminuser = request.getParameter("adminuser");
			String adminpass = request.getParameter("adminpass");
			String adminame = request.getParameter("adminame");
			String telephone = request.getParameter("telephone");
			Integer power = Integer.parseInt(request.getParameter("level"));
			String adminemail = request.getParameter("adminemail");
			
			String adminid = UUIDUtils.getId();
			
			AdminUser au = new AdminUser();
			au.setAdminid(adminid);
			au.setAdminuser(adminuser);
			au.setAdminpass(adminpass);
			au.setAdminemail(adminemail);
			au.setAdminame(adminame);
			
			Date date=new Date();                             
	         SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	         String date2=temp.format(date);  
	         Date date3=temp.parse(date2);  
	         
			au.setCreatetime(date3);
			au.setTelephone(telephone);
			au.setPower(power);
			au.setLoginip(InetAddress.getLocalHost().getHostAddress());
			au.setLogintime(date3);
			//存入数据库
			AdUserService ads = (AdUserService) BeanFactory.getBean("AdUserService");
			ads.addAdmin(au);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findAll(request, response);
	}
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<AdminUser> au = ads.findAll();
			request.setAttribute("admin", au);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/main_list.jsp";
	}
	
	//通过id删除
	public String deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    try {
			String adminid = request.getParameter("adminid");
			ads.deleteById(adminid);
			String json="{\"msg\":\"删除成功\"}";
			response.getWriter().println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//登录验证
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String adminuser = request.getParameter("login");
			String adminpass = request.getParameter("pwd");
			String vcode=request.getParameter("vcode");
			if(vcode.equalsIgnoreCase((String) request.getSession().getAttribute("code"))){
			AdminUser au = ads.login(adminuser,adminpass);
			
			if(au != null) {
				HttpSession session = request.getSession();
				session.setAttribute("aduser", au);
				String jsonData = "{\"msg\":\"登录成功\"}";
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(jsonData);
//				response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
			}else {
				String jsonData = "{\"msg\":\"用户名或密码错误！！！\"}";
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(jsonData);
			}
			}else{
				String jsonData = "{\"msg\":\"验证码错误\"}";
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().print(jsonData);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String findAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<User> user = ads.findAllUser();
			request.setAttribute("usee", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/main_userlist.jsp";
	}
	
	//删除用户
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String uid = request.getParameter("uid");
			us.deleteUser(uid);
			String json = "{\"msg\":\"ok\"}";
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//添加用户
	public String addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			// 封装对象
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			// 手动封装uid
			user.setUid(UUIDUtils.getId());
			// 手动封装start
			user.setState(Constant.USER_IS_NOT_ACTIVE);
			// 手动封装code
			user.setCode(UUIDUtils.getCode());

			// 调用service完成注册
			UserService ud = new UserServiceImpl();
			ud.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findAllUser(request, response);
	}
	
	/*
	 * 修改激活状态
	 */
	public String updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String uid = request.getParameter("uid");
			us.updateState(uid);
			String json = "{\"msg\":\"ok\"}";
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 注销
	 */
	public String adexitUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("aduser");
		return "/admin/login.jsp";
	}
	
	//登录首页
	public String findMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
		return "/admin/main.jsp";
	}
	
	/*
	 * 修改用户属性
	 */
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			us.updateUser(user);
			String json = "{\"msg\":\"200\"}";
			response.getWriter().println(json);
		} catch (Exception e) {
		}
		return null;
	}
	
	/*
	 * 修改管理员信息
	 */
	public String updataAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			AdminUser adus = new AdminUser();
			BeanUtils.populate(adus, request.getParameterMap());
			ads.updataAdmin(adus);
			String json ="{\"msg\":\"200\"}";
			response.getWriter().println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}














