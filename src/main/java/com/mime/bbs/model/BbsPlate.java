package com.mime.bbs.model;

import java.sql.Timestamp;

public class BbsPlate {
	private Integer id;
	private String plateName;
	private Integer parentId;
	private Integer sort;
	private String plateDescribe;
	private Integer isDisable;
	private Timestamp gmtCreate;
	private Timestamp gmtModified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getPlateDescribe() {
		return plateDescribe;
	}
	public void setPlateDescribe(String plateDescribe) {
		this.plateDescribe = plateDescribe;
	}
	
	
	public Integer getIsDisable() {
		return isDisable;
	}
	public void setIsDisable(Integer isDisable) {
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
	
}
