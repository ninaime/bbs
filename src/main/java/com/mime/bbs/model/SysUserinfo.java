package com.mime.bbs.model;

import java.sql.Timestamp;

public class SysUserinfo {
	private Integer id;
	private SysUser user;
	private Integer sex;
	private Timestamp birthday;
	private String address;
	private Integer jobId;
	private Integer exp;
	private String sign;
	private Integer inegral;
	private String ip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getInegral() {
		return inegral;
	}
	public void setInegral(Integer inegral) {
		this.inegral = inegral;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "SysUserinfo [id=" + id + ", user=" + user + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", jobId=" + jobId + ", exp=" + exp + ", sign=" + sign + ", inegral=" + inegral + ", ip="
				+ ip + "]";
	}

	
	
}
