package com.mime.bbs.util;

import java.net.InetAddress;

public class NetworkUtils {
	public static String getLocalHostLANAddress() {
		InetAddress inetAddress=null;
		try{
			inetAddress= InetAddress.getLocalHost();
			System.out.println("你的IP地址是："+inetAddress.getHostAddress());
			System.out.println("主机名为："+inetAddress.getHostName());
		}catch(Exception e){
			e.printStackTrace();
		}
		return inetAddress.getHostAddress();
	}
	
}
