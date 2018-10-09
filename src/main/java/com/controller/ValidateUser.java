package com.controller;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Passanger;
import com.exception.DatabaseException;

import dao.PassangerDao;
import dao.UserDao;

@WebServlet(value="/validate", asyncSupported=true)
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 4413832082411342836L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String utype = request.getParameter("utype");

		String user = null;
		try {
			user = UserDao.selectUser(uname, password, utype);
			if (user != null) {
			AsyncContext ctx=request.startAsync();
			HttpSession session = request.getSession(true);
			ctx.start(()->{
			try {
				Passanger i = PassangerDao.getPassanger(uname);
				session.setAttribute("p", i);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				session.setAttribute("username", uname);
				
				session.setAttribute("usertype", utype);
				ctx.complete();
			});
			response.sendRedirect("search.jsp");
			System.out.println("redirected");
			} else {
				request.setAttribute("error", "Invalid username/password");
				response.sendRedirect("login.jsp");
			}
		} catch (DatabaseException e) {
			request.setAttribute("error", e.getMessage());
			response.sendRedirect("login.jsp");
			e.printStackTrace();
		}
	}
}
