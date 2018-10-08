package dbUtility;

import java.io.IOException;
import java.util.Properties;

import com.exception.DatabaseException;

public class PropertyReader {
	public static Properties readPropertyFile() throws DatabaseException {
		Properties p = new Properties();
		try {
			p.load(PropertyReader.class.getResourceAsStream("/db.properties"));
		} catch (IOException e) {
			throw new DatabaseException("Unable to load database details !!");
		}
		return p;
	}
	
}
