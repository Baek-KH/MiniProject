package com.lec.project.vo;

import java.util.Objects;

public class User_addressVO {
	                        
	private String user_id   ;
	private String user_addr1;
	private String user_addr2;
	private String user_addr3;

	public User_addressVO() {
		// TODO Auto-generated constructor stub
	}

	public User_addressVO(String user_id, String user_addr1, String user_addr2, String user_addr3) {
		super();
		this.user_id = user_id;
		this.user_addr1 = user_addr1;
		this.user_addr2 = user_addr2;
		this.user_addr3 = user_addr3;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_addr1
	 */
	public String getUser_addr1() {
		return user_addr1;
	}

	/**
	 * @param user_addr1 the user_addr1 to set
	 */
	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}

	/**
	 * @return the user_addr2
	 */
	public String getUser_addr2() {
		return user_addr2;
	}

	/**
	 * @param user_addr2 the user_addr2 to set
	 */
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}

	/**
	 * @return the user_addr3
	 */
	public String getUser_addr3() {
		return user_addr3;
	}

	/**
	 * @param user_addr3 the user_addr3 to set
	 */
	public void setUser_addr3(String user_addr3) {
		this.user_addr3 = user_addr3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User_addressVO other = (User_addressVO) obj;
		return Objects.equals(user_id, other.user_id);
	}

	@Override
	public String toString() {
		return "User_addressVO [user_id=" + user_id + ", user_addr1=" + user_addr1 + ", user_addr2=" + user_addr2
				+ ", user_addr3=" + user_addr3 + "]";
	}
	
	
	
}
