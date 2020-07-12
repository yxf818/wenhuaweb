package com.web.service;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseService
 */
@WebServlet("/BaseService")
public class BaseService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		try {
			// 获取方法名
			String mName = request.getParameter("method");

			if (mName == null || mName.trim().length() == 0) {
				mName = "index";
			}

			// 获取方法对象
			Method method = this.getClass().getMethod(mName, HttpServletRequest.class, HttpServletResponse.class);

			// 让方法执行，接收返回值
			String path = (String) method.invoke(this, request, response);

			// 判断返回值是否为空
			if (path != null) {
				request.getRequestDispatcher(path).forward(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("请不要捣乱！");
		return null;
	}
}
