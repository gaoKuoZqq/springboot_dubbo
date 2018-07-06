package com.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.producer.service.TestService;

@RestController
@RequestMapping("test")
public class TestController {
	@Reference(version = "1")
	private TestService testService;
	@RequestMapping("test")
	public String test(String param) {
		return testService.test(param);
	}
}
