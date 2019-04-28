package com.mime.bbs.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groovy.util.logging.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BackLogTest{
	
	private final Logger logger = LoggerFactory.getLogger(BackLogTest.class);
	
	@Test
	public void test1() {
		logger.debug("debug.......");
		logger.info("info.......");
		logger.error("error.........");

	}
}
