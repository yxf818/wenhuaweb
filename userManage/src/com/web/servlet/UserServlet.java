package com.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.web.constant.Constant;
import com.web.domain.User;
import com.web.service.BaseService;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;
import com.web.utils.UUIDUtils;

/**
 * Servlet implementation class UserService
 */
@WebServlet("/UserService")
public class UserServlet extends BaseService {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */

	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			ud.regist(user);
			// 页面转发信息提示
			request.setAttribute("msg", "注册成功！");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			request.setAttribute("msg", "用户注册失败！");
			return "/jsp/msg.jsp";
		}

		return "/jsp/msg.jsp";

	}

	public String registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/register.jsp";
	}

	/*
	 * 邮箱验证
	 */
	public String active(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// 接收页面发送的code
			String code = request.getParameter("code");

			// 调用Service完成激活
			UserService us = new UserServiceImpl();
			User user = us.active(code);

			// 判断是否为空
			if (user.getCode() == null) {
				request.setAttribute("msg", "验证失败！");
			}
			request.setAttribute("msg", "恭喜你验证成功，可以登录使用");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "验证失败！");
		}

		return "/jsp/msg.jsp";
	}

	/*
	 * 用户登录跳转
	 */
	public String loginUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/login.jsp";
	}

	/*
	 * 用户登录验证
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 获取页面传来的用户名和密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// 调用Service完成登录，返回user
			UserService us = new UserServiceImpl();
			User user = us.loign(username, password);

			// 用户不匹配
			if (user.getUid() == null || user.getUid().equals("")) {
				request.setAttribute("msg", "您输入的帐号或密码有误");
				return "/jsp/login.jsp";
			}
			// 判断账号是否激活
			if (Constant.USER_IS_ACTIVE != user.getState()) {
				request.setAttribute("msg", "对不起，您输入的帐号未激活");
				return "/jsp/login.jsp";
			}
			// 登录成功，保存用户状态在session中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 保存用户名
			if (Constant.SAVA_NAME.equals(request.getParameter("saveName"))) {
				Cookie cook = new Cookie("saveName", URLEncoder.encode(username, "utf-8"));
				cook.setMaxAge(Integer.MAX_VALUE);
				cook.setPath(request.getContextPath() + "/");
				response.addCookie(cook);
			}

			/*
			 * 重定向到首页
			 */
			response.sendRedirect(request.getContextPath());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "用户登录失败！详情请咨询客服。");
			return "/jsp/msg.jsp";
		}

		return null;
	}

	/*
	 * 用户注销登录
	 */
	public String exitUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "index.jsp";
	}
}
