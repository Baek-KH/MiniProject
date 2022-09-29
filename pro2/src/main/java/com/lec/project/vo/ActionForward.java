package com.lec.project.vo;

public class ActionForward {
	 
	private boolean isRedirect = false;
	private String path = null;
	
	/**
	 * @return the isRedirect
	 */
	public boolean isRedirect() {
		return isRedirect;
	}
	/**
	 * @param isRedirect the isRedirect to set
	 */
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
		
	
}
