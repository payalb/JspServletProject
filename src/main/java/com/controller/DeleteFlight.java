package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.DatabaseException;

import dao.FlightDao;
import dao.SeatDao;

@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 7950725441754741291L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int fno = Integer.parseInt(request.getParameter("fno"));
		try {

			SeatDao.removeFlight(fno);
			FlightDao.removeFlight(fno);
			request.getRequestDispatcher("listFlight").forward(request, response);
		} catch (DatabaseException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}

	}
}
