package com.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.flywaydb.core.Flyway;

import com.exception.DatabaseException;

import dbUtility.DBStore;

@WebListener
public class FlywayListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        Flyway flyway = new Flyway();
        try {
			flyway.setDataSource(DBStore.getDataSource());
			flyway.setBaselineOnMigrate(true);
			flyway.setLocations("classpath:/migration");
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
        flyway.migrate();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}