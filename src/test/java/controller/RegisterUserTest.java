package controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.controller.RegisterUser;
import com.exception.DatabaseException;

import dbUtility.PropertyReader;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyReader.class)
public class RegisterUserTest {
	
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock 
	PropertyReader obj;
	@Mock
	RequestDispatcher rd;
	
	@Before
	public void init() throws DatabaseException, IOException {
		PowerMockito.mockStatic(PropertyReader.class);
		Properties p = new Properties();
		
		p.load(this.getClass().getResourceAsStream("/db_test.properties"));
	when(obj.readPropertyFile()).thenReturn(p);
	}

	@Test
	public void test() throws IOException, ServletException {
		when(req.getParameter("uname")).thenReturn("abc");
		when(req.getParameter("password")).thenReturn("123");
		when(req.getParameter("utype")).thenReturn("admin");
		when(req.getParameter("fname")).thenReturn("abc");
		when(req.getParameter("lname")).thenReturn("cde");
		when(req.getParameter("ssn")).thenReturn("789123456");
		when(req.getParameter("email")).thenReturn("abc@abc.com");
		when(req.getParameter("age")).thenReturn("25");
		when(req.getParameter("street")).thenReturn("King drive");
		when(req.getParameter("apt")).thenReturn("1000");
		when(req.getParameter("city")).thenReturn("chicago");
		when(req.getParameter("state")).thenReturn("IL");
		when(req.getParameter("zip")).thenReturn("60000");
		when(req.getParameter("thome")).thenReturn("987654321");
		when(req.getParameter("toffice")).thenReturn("987654321");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		
		RegisterUser ru=new RegisterUser();
		ru.doPost(req, res);
		
		verify(req,times(1)).getRequestDispatcher("/login.jsp");
	}

}
