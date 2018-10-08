package com.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.exception.DatabaseException;

import dao.PassangerDao;
import dao.UserDao;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserDao.class, PassangerDao.class ,ValidateUser.class})
@PowerMockIgnore("javax.management.*")
public class ValidateUserTest {
	
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock RequestDispatcher dispatcher;
	@Mock RequestDispatcher dispatcher1;
	ValidateUser user= new ValidateUser();
	
	@Test
	public void test1() throws IOException, ServletException, DatabaseException {
		PowerMockito.mockStatic(UserDao.class);
		when(UserDao.selectUser(anyString(), anyString(), anyString())).thenReturn(null);
		PowerMockito.mockStatic(PassangerDao.class);
		when(PassangerDao.getPassanger(anyString())).thenReturn(null);
		Mockito.when(request.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);
		Mockito.when(request.getRequestDispatcher("/search.jsp")).thenReturn(dispatcher1);
		user.doPost(request, response);
		Mockito.verify(dispatcher).forward(request, response);
		Mockito.verify(dispatcher1,Mockito.never()).forward(request, response);
	}

}
