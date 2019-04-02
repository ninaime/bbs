package com.mime.bbs.model;

import java.sql.Date;

public class Article {
	private Integer id;
	private String catalogId;
	private String title;
	private String englishTitle;
	private String summary;
	private String tags;
	private String authorId;
	private String context;
	private Integer viewCount;
	private Integer commentCount;
	private Integer weight;
	private Integer isDisable;
	private Date gmtCreate; 
	private Date gmtModified;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEnglishTitle() {
		return englishTitle;
	}
	public void setEnglishTitle(String englishTitle) {
		this.englishTitle = englishTitle;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getIsDisable() {
		return isDisable;
	}
	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	@Override
	public String toString() {
		return "SysArticle [id=" + id + ", catalogId=" + catalogId + ", title=" + title + ", englishTitle="
				+ englishTitle + ", summary=" + summary + ", tags=" + tags + ", authorId=" + authorId + ", context="
				+ context + ", viewCount=" + viewCount + ", commentCount=" + commentCount + ", weight=" + weight
				+ ", isDisable=" + isDisable + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
	
	
}
