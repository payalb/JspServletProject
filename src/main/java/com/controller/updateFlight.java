package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.bean.Seat;
import com.exception.DatabaseException;

import dao.FlightDao;
import dao.SeatDao;

@WebServlet("/updateFlight")
public class updateFlight extends HttpServlet {
	private static final long serialVersionUID = 1081505288533693861L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int fno = Integer.parseInt(request.getParameter("fno"));
		String a_time = request.getParameter("atime");
		String a_date = request.getParameter("adate");
		String d_time = request.getParameter("dtime");
		String d_date = request.getParameter("ddate");
		int air_id = Integer.parseInt(request.getParameter("air_id"));
		String d_city = request.getParameter("d_city");
		String a_city = request.getParameter("a_city");

		Date ddate = Date.valueOf(d_date);
		Date adate = Date.valueOf(a_date);
		Time dtime = Time.valueOf(d_time);
		Time atime = Time.valueOf(a_time);
		int eseat = Integer.parseInt(request.getParameter("eseat"));
		int fseat = Integer.parseInt(request.getParameter("fseat"));
		int bseat = Integer.parseInt(request.getParameter("bseat"));
		Flight f = new Flight(fno, atime, adate, dtime, ddate, air_id, d_city, a_city);
		Seat s = new Seat(fno, eseat, fseat, bseat);
		try {
			FlightDao.updateFlight(f);
			SeatDao.updateSeat(s);

			request.getRequestDispatcher("listFlight").forward(request, response);
		} catch (DatabaseException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}
