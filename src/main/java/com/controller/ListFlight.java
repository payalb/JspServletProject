package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.exception.DatabaseException;

import dao.FlightDao;

@WebServlet("/listFlight")
public class ListFlight extends HttpServlet {
	private static final long serialVersionUID = 3381332556426784213L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Flight> fli = new ArrayList<>();

		try {
			fli = FlightDao.selectAllFlight();

			request.setAttribute("list", fli);
			request.getRequestDispatcher("/displayList.jsp").forward(request, response);
		} catch (DatabaseException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}
