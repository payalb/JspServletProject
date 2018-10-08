package dbUtility;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.exception.DatabaseException;

public class DBStore {
	static Properties property;
	
	public  static BasicDataSource getDataSource() throws DatabaseException {
		property= getProperty();
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(property.getProperty("DB_Driver"));
		ds.setUrl(property.getProperty("DB_URL"));
		ds.setPassword(property.getProperty("DB_Password"));
		ds.setUsername(property.getProperty("DB_User"));
		ds.setMaxTotal(200);// load testing get connection :(2sec) close the connection
		ds.setMaxIdle(20);
		ds.setMaxOpenPreparedStatements(180);
		System.out.println(ds.getUrl());
		ds.setMinIdle(20);
		ds.setMaxWaitMillis(2000);// 2sec
		ds.setDefaultAutoCommit(false);
		return ds;
	}

	public static Properties getProperty() {
		return property;
	}

	static {
		try {
			property=PropertyReader.readPropertyFile();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
