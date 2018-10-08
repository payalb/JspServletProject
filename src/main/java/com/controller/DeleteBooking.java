package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.DatabaseException;

import dao.BookDao;

@WebServlet("/deleteBooking")
public class DeleteBooking extends HttpServlet {

	private static final long serialVersionUID = -6651908218510825906L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int bId = Integer.parseInt(request.getParameter("bId"));
		// int fno = Integer.parseInt(request.getParameter("fno"));??

		try {
			// Flight f=FlightDao.getFlight(fno);??
			BookDao.removeBooking(bId);
			request.getRequestDispatcher("bookHistory").forward(request, response);
		} catch (DatabaseException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}

	}
}
