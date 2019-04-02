package com.mime.bbs.util;

import org.junit.Test;

public class NetworkUtilsTest {
	
	@Test
	public void getLocalHostLANAddressTest() {
		System.out.println("本机地址为："+NetworkUtils.getLocalHostLANAddress());
	}
}
