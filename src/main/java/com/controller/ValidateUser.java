package com.controller;

import java.io.IOException;

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

@WebServlet("/validate")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 4413832082411342836L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String utype = request.getParameter("utype");
		Passanger i = null;

		String user = null;
		try {
			user = UserDao.selectUser(uname, password, utype);
			i = PassangerDao.getPassanger(uname);

			if (user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", uname);
				session.setAttribute("p", i);
				session.setAttribute("usertype", utype);
				request.getRequestDispatcher("/search.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Invalid username/password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (DatabaseException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}
