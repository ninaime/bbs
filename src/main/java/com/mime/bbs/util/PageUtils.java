package com.mime.bbs.util;

public class PageUtils {
	private int rowCount;//总条数
	private int pageSize;//一页多少条数据
	private int beginIndex;//首页
	private int endIndex;//多少页
	private int pageNum;//当前页数
	
    public PageUtils(){
    	this.beginIndex=1;
    	this.pageNum=1;
    	this.pageSize=10;
    }
   



	public int getRowCount() {
		return rowCount;
	}


	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getBeginIndex() {
		return beginIndex;
	}


	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}


	public int getEndIndex() {
		return endIndex;
	}


	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}