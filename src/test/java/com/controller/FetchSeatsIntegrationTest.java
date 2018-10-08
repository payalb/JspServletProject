package com.controller;

import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.exception.DatabaseException;
@RunWith(MockitoJUnitRunner.class)
public class FetchSeatsIntegrationTest {

	FetchSeats fetchSeats= new FetchSeats();
	@Mock HttpServletRequest request;
	@Mock HttpServletResponse response;
	
	@Test
	public void test1() throws IOException, ServletException, DatabaseException {
		Mockito.when(request.getParameter(anyString())).thenReturn("-1");
		RequestDispatcher dispatcher=Mockito.mock(RequestDispatcher.class);
		Mockito.when(request.getRequestDispatcher("/Error.jsp")).thenReturn(dispatcher);
		fetchSeats.doGet(request, response);
		Mockito.verify(dispatcher).forward(request, response);
	}

}
