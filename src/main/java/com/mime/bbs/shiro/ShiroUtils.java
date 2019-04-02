package com.mime.bbs.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroUtils {
	public final static String MD5(String username,String password) {
		//加密类型
		String algorithmName="MD5";
		//加密密码
		Object source = password;
		//盐值加密唯一标识
		Object salt = ByteSource.Util.bytes(username);
		//加密次数
		int hashIterations = 1024;
		
		Object object = new SimpleHash(algorithmName, source, salt, hashIterations);
		return object.toString();
	}

}
