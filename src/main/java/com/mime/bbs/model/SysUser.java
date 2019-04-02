package com.mime.bbs.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 映射数据库实体类
 */
public class SysUser implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

    private String nickname;

    //用户名不能为空
    @NotEmpty(message="{sysUser.username}")
    private String username;

    //密码长度必须在6-18位之间
    @Length(min=6,max=18,message="{sysUser.password}")
    private String password;

    private String phone;
    
    //邮箱格式必须合法（xxxx@xx.xxx）
    //@Email(regexp="^[_a-z0-9]+@([_a-z0-9]+\\.)+[a-z0-9] {2,3}$",message="{sysUser.email}")
    private String email;
    
    private String avatar;//头像

    private Integer isDisable;//状态验证

    private Integer isOnline;//是否在线
    
    private SysRole role;//权限，复合属性

    private Timestamp gmtCreate;
    
    private Timestamp gmtModified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public Timestamp getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Timestamp getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", nickname=" + nickname + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", avatar=" + avatar + ", isDisable=" + isDisable
				+ ", isOnline=" + isOnline + ", role=" + role + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + "]";
	}
    
	
}