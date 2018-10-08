package dbUtility;

import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.exception.DatabaseException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PropertyReader.class,DBStore.class}) //whatever class we are mocking
@PowerMockIgnore("javax.management.*")
public class DBStoreTest {

	@Test
public void test() throws IOException, DatabaseException {
	PowerMockito.mockStatic(PropertyReader.class);
	Properties p = new Properties();
	p.load(DBStoreTest.class.getResourceAsStream("/db_test.properties"));
	when(PropertyReader.readPropertyFile()).thenReturn(p);
	DBStore.getDataSource();
}
}
