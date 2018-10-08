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
import com.google.gson.Gson;

import dao.FlightDao;

@WebServlet("/autocomplete")
public class Autocomplete extends HttpServlet {
	private static final long serialVersionUID = -143207776147172486L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Autocomplete");
		System.out.println(request.getParameter("city"));
		String city = request.getParameter("city");
		response.setContentType("application/json");
		List<Flight> list = new ArrayList<>();
		List<Flight> citylist = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		try {
			list = FlightDao.selectAllFlight();

			System.out.println(new Gson().toJson(list));

			if (!city.equals("")) {

				for (Flight li : list) {

					if (li.getArrival_city().toLowerCase().startsWith(city.toLowerCase())
							|| li.getDeparture_city().toLowerCase().startsWith(city.toLowerCase())) {
						citylist.add(li);
					}
				}
			}
			System.out.println(sb.toString());

			response.getWriter().write(new Gson().toJson(citylist));

		} catch (DatabaseException e) {
			 request.setAttribute("error","Autocompletion failed"+ e.getMessage());
				e.printStackTrace();
				 request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}
}
