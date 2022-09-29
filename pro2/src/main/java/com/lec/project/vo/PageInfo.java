package com.lec.project.vo;

public class PageInfo {
	
	private int page;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int listCount;
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the startPage
	 */
	public int getStartPage() {
		return startPage;
	}
	/**
	 * @param startPage the startPage to set
	 */
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	/**
	 * @return the endPage
	 */
	public int getEndPage() {
		return endPage;
	}
	/**
	 * @param endPage the endPage to set
	 */
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	/**
	 * @return the listCount
	 */
	public int getListCount() {
		return listCount;
	}
	/**
	 * @param listCount the listCount to set
	 */
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	
	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", listCount=" + listCount + "]";
	}
	
		

	
}
