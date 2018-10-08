package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BHistory;
import com.bean.Booking;
import com.bean.Flight;
import com.exception.DatabaseException;

import dao.BookDao;
import dao.FlightDao;
import dao.PassangerDao;

@WebServlet("/bookHistory")
public class BookHistory extends HttpServlet {
	private static final long serialVersionUID = 8399234979095098893L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);

		}
		int pId = 0;
		List<BHistory> bh = new ArrayList<>();
		String uname = (String) session.getAttribute("username");
		try {
			pId = PassangerDao.getPassangerId(uname);

			System.out.println(pId);
			List<Booking> blist = new ArrayList<>();
			Flight flist = null;
			blist = BookDao.getBooking(pId);

			for (Booking i : blist) {
				i.getFlight_number();
				flist = FlightDao.getFlight(i.getFlight_number());
				System.out.println(flist);
				BHistory bhistory = new BHistory(i.getBooking_id(), i.getPassanger_id(), i.getFlight_number(),
						flist.getArrival_time(), flist.getArrival_date(), flist.getDeparture_time(),
						flist.getDeparture_date(), flist.getAirplane_id(), flist.getDeparture_city(),
						flist.getArrival_city());
				bh.add(bhistory);
			}
			request.setAttribute("blist", bh);
			request.getRequestDispatcher("/bookingHistory.jsp").forward(request, response);

		} catch (DatabaseException e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
	}
}
