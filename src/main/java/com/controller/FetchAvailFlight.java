package com.controller;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/fetchAvailFlight")
public class FetchAvailFlight extends HttpServlet {
	private static final long serialVersionUID = 1012300161594262811L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Flight> fli = new ArrayList<>();
		String dep_city = request.getParameter("from");
		String arr_city = request.getParameter("to");
		String d = request.getParameter("ondate");
		Date date = Date.valueOf(d);

		try {
			fli = FlightDao.selectFlight(date, dep_city, arr_city);

			System.out.println(fli);
			request.setAttribute("list", fli);
			request.getRequestDispatcher("/displayFlight.jsp").forward(request, response);
		} catch (DatabaseException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

}
