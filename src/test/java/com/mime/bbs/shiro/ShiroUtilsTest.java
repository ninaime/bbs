package com.mime.bbs.shiro;

import org.junit.Test;


public class ShiroUtilsTest{
	
	@Test
	public void MD5Test() {
		//038bdaf98f2037b31f1e75b5b4c9b26e
		System.out.println(ShiroUtils.MD5("admin", "123456"));
		//4292bb58be34c59d28a0dcbd11932d49
		System.out.println(ShiroUtils.MD5("test", "123456"));
	}
}
