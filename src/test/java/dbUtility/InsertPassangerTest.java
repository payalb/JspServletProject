//package dbUtility;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.bean.Passanger;
//
//public class InsertPassangerTest {
//	@Mock PropertyUtil obj;
//	//@InjectMocks DBStore obj1;
//	DBStore obj1=new DBStore();
//	@Before
//	public void init() throws IOException {
//		MockitoAnnotations.initMocks(this);
//		Properties p = new Properties();
//		
//		p.load(PropertyUtil.class.getResourceAsStream("/db_test.properties"));
//	when(obj.readPropertyFile()).thenReturn(p);
//	}
//	
//	
//	@Test
//	public void test() throws IOException, SQLException {
//		Passanger p =new Passanger(15,null,"Sohan","P","3345",25,"St Charles",1000,"St Charles","IL",12345,"12345","456789","abc@abc.com");
//		Connection conn =  obj1.getConnection();
//		assertEquals(1,SQLUtility.insertPassanger(p,conn));
//	}
//
//}
