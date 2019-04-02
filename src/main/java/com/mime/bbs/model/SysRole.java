package com.mime.bbs.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysRole implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String roleName;
    
    private String permission;

    private String roleDescribe;
    
    private boolean isDisable;
    
    private Timestamp gmtCreate;

	private Timestamp gmtModified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	public boolean isDisable() {
		return isDisable;
	}

	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
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
		return "SysRole [id=" + id + ", roleName=" + roleName + ", permission=" + permission + ", roleDescribe="
				+ roleDescribe + ", isDisable=" + isDisable + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + "]";
	}
	
}