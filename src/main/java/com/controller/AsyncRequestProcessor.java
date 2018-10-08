package com.controller;
/*package controller;

import java.util.concurrent.Callable;

import javax.servlet.AsyncContext;

import com.bean.Passanger;
import com.bean.User;
import com.exception.DatabaseException;

import dao.PassangerDao;
import dao.UserDao;

public class AsyncRequestProcessor implements Callable<Void> {

	AsyncContext ctx;
	private User user;
	private Passanger p;

	public AsyncRequestProcessor(AsyncContext ctx, User user, Passanger p) {
		this.ctx = ctx;
		this.user= user;
		this.p= p;
	}

	@Override
	public Void call() throws DatabaseException {
			UserDao.insertUser(user);
			PassangerDao.insertPassanger(p);
			ctx.complete();
			return null;
	}

}
*/