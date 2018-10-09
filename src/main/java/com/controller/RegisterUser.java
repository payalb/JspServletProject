package com.controller;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Passanger;
import com.bean.User;
import com.exception.DatabaseException;

import dao.PassangerDao;
import dao.UserDao;

@WebServlet(value="/registerUser", asyncSupported=true)
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = -7912217352920932152L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String utype = request.getParameter("utype");
		User user = new User(uname, password, utype);

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
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

		Passanger p = new Passanger(uname, fname, lname, ssn, age, street, apt, city, state, zip, thome, toffice,
				email);
		AsyncContext ctx= request.startAsync();
		/*ThreadPoolExecutor executor = (ThreadPoolExecutor) request
				.getServletContext().getAttribute("executor");
		executor.submit(new AsyncRequestProcessor(ctx,user,p));*/
		System.out.println(Thread.currentThread().getName()+"*");
		ctx.start(()->{
			try {
				System.out.println(Thread.currentThread().getName());
				UserDao.insertUser(user);
				PassangerDao.insertPassanger(p);
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
			ctx.complete();
		});
		//cannot send post request to this url
			response.sendRedirect("login.jsp");
			
	}
}
