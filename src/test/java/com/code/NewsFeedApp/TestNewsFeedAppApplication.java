package com.code.NewsFeedApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestNewsFeedAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(NewsFeedAppApplication::main).with(TestNewsFeedAppApplication.class).run(args);
	}

}
