package com.producer.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1")
public class TestServiceImpl implements TestService{

	public String test(String param) {
		return "TestService_two->success->param:" + param;
	}
}
