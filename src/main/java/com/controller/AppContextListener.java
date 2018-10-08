package com.controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener{

	public  void contextInitialized(ServletContextEvent sce) {
		// create the thread pool
				ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 50000L,
						TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
				sce.getServletContext().setAttribute("executor",
						executor);

	}
	public void contextDestroyed(ServletContextEvent sce) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) sce
				.getServletContext().getAttribute("executor");
		executor.shutdown();
	}
}
