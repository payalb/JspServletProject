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

@WebServlet("/addProfile")
public class AddProfile extends HttpServlet {
	private static final long serialVersionUID = -8938589937009133749L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int pid = Integer.parseInt(request.getParameter("pid"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("username");
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String street = request.getParameter("street");
		int apt = Integer.parseInt(request.getParameter("apt"));
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String thome = request.getParameter("thome");
		String toffice = request.getParameter("toffice");

		Passanger p = new Passanger(pid, uname, fname, lname, ssn, age, street, apt, city, state, zip, thome, toffice,
				email);
		int id = 0;
		try {
			int ret = PassangerDao.updatePassanger(p);
			if (ret == 1) {
				id = PassangerDao.getPassangerId(uname);
				HttpSession session = request.getSession(false);
				session.setAttribute("pid", id);
			}
			System.out.println(ret);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (DatabaseException e) {
			e.printStackTrace();
			request.setAttribute("error","Autocompletion failed"+ e.getMessage());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
	}
}
