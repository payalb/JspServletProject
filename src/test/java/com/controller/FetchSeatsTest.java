package com.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Seat;
import com.exception.DatabaseException;
import com.google.gson.Gson;

import dao.SeatDao;
@RunWith(PowerMockRunner.class)
@PrepareForTest(SeatDao.class)
public class FetchSeatsTest {

	FetchSeats fetchSeats= new FetchSeats();
	@Mock HttpServletRequest request;
	@Mock HttpServletResponse response;
	@Test
	public void test1() throws IOException, ServletException, DatabaseException {
		Mockito.when(request.getParameter(anyString())).thenReturn("43");
		PowerMockito.mockStatic(SeatDao.class);
		PowerMockito.when(SeatDao.getSeats(anyInt())).thenReturn(new Seat(1,1,1,1));
		StringWriter obj= new StringWriter();
		Mockito.when(response.getWriter()).thenReturn(new PrintWriter(obj));
		fetchSeats.doGet(request, response);
		assertEquals(new Gson().toJson(new Seat(1,1,1,1)),obj.toString());
		Mockito.verify(response).getWriter();
	}
	
	@Test
	public void test2() throws IOException, ServletException, DatabaseException {
		Mockito.when(request.getParameter(anyString())).thenReturn("43");
		PowerMockito.mockStatic(SeatDao.class);
		PowerMockito.when(SeatDao.getSeats(anyInt())).thenReturn(null);
		RequestDispatcher dispatcher=Mockito.mock(RequestDispatcher.class);
		Mockito.when(request.getRequestDispatcher("/Error.jsp")).thenReturn(dispatcher);
		fetchSeats.doGet(request, response);
		Mockito.verify(dispatcher).forward(request, response);
	}
}
