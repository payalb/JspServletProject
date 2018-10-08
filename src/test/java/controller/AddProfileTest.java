package controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Passanger;
import com.controller.AddProfile;
import com.exception.DatabaseException;

import dao.PassangerDao;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PassangerDao.class)
public class AddProfileTest {

	
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock
	RequestDispatcher rd;
	@Before
	public void init() throws DatabaseException {
		PowerMockito.mockStatic(PassangerDao.class);
		when(PassangerDao.insertPassanger(new Passanger())).thenReturn(1);
		
	}
	@Test
	public void test() throws IOException, ServletException {
		when(req.getParameter("fname")).thenReturn("abc");
		when(req.getParameter("lname")).thenReturn("abc");
		when(req.getParameter("username")).thenReturn("user");
		when(req.getParameter("ssn")).thenReturn("12345");
		when(req.getParameter("email")).thenReturn("abc@abc.com");
		when(req.getParameter("age")).thenReturn("2");
		when(req.getParameter("street")).thenReturn("king dr");
		when(req.getParameter("apt")).thenReturn("1000");
		when(req.getParameter("city")).thenReturn("chicago");
		when(req.getParameter("state")).thenReturn("IL");
		when(req.getParameter("zip")).thenReturn("60000");
		when(req.getParameter("thome")).thenReturn("987654321");
		when(req.getParameter("toffice")).thenReturn("987654321");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		
		AddProfile profile= new AddProfile();
		profile.doPost(req, res);
		verify(req,times(0)).getRequestDispatcher("/Error.jsp");
		verify(req,times(1)).getRequestDispatcher("search.jsp");
	}

}
