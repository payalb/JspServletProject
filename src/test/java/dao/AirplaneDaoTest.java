package dao;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Airplane;
import com.exception.DatabaseException;

import dbUtility.DBStore;
import dbUtility.PropertyReader;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PropertyReader.class,DBStore.class, AirplaneDao.class}) //whatever class we are mocking
@PowerMockIgnore("javax.management.*")
public class AirplaneDaoTest {

	static AirplaneDao dao;
	
	@BeforeClass
	public static void init() throws DatabaseException, IOException {
		dao = new AirplaneDao();
		Properties p = new Properties();
		p.load(AirplaneDaoTest.class.getResourceAsStream("/db_test.properties"));
		System.out.println(p.getProperty("DB_URL"));
		PowerMockito.mockStatic(PropertyReader.class);
		when(PropertyReader.readPropertyFile()).thenReturn(p);
		when(DBStore.getProperty()).thenReturn(p);
	}
	@Test(expected=DatabaseException.class)
	public void test1() throws DatabaseException {
		dao.insertAirplane(null);
	}

	@Test(expected=DatabaseException.class)
	public void test2() throws DatabaseException {
		Airplane obj= new Airplane();
		obj.setProducer("abc");
		obj.setType(1);
		dao.insertAirplane(obj);
	}
	
	@Test(expected=DatabaseException.class)
	public void test3() throws DatabaseException {
		Airplane obj= new Airplane();
		obj.setAirplane_id(1);
		obj.setType(1);
		dao.insertAirplane(obj);
	}
	
	@Test(expected=DatabaseException.class)
	public void test4() throws DatabaseException {
		Airplane obj= new Airplane();
		obj.setAirplane_id(1);
		obj.setProducer("abc");
		dao.insertAirplane(obj);
	}
	
	@Test
	public void test5() throws DatabaseException, SQLException {
		
		Airplane obj= new Airplane();
		obj.setAirplane_id(1);
		obj.setProducer("abc");
		obj.setType(1);
		dao.insertAirplane(obj);
		Connection c=DBStore.getDataSource().getConnection();
		Statement st=c.createStatement();
		st.executeUpdate("delete from Airplane where Airplane_id = 1");
		c.commit();
	}
	
}
