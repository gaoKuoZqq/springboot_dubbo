package com.consumer.controller;

import java.util.concurrent.Callable;

public class TtS implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(1000*10);
		return "success!";
	}

}
