package com.lec.project.vo;

import java.util.Objects;

public class UserVO extends User_addressVO{

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_phone;
	private String user_gender;
	private String user_email;
	private String user_joind;
	
	
	
	public UserVO() {
		super();
	}


	public UserVO(String user_id, String user_pw, String user_name, String user_phone, String user_gender,
			String user_emain ) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_gender = user_gender;
		this.user_email = user_emain;
		
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
	 * @return the user_pw
	 */
	public String getUser_pw() {
		return user_pw;
	}


	/**
	 * @param user_pw the user_pw to set
	 */
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}


	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	/**
	 * @return the user_phone
	 */
	public String getUser_phone() {
		return user_phone;
	}


	/**
	 * @param user_phone the user_phone to set
	 */
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	/**
	 * @return the user_gender
	 */
	public String getUser_gender() {
		return user_gender;
	}


	/**
	 * @param user_gender the user_gender to set
	 */
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}


	/**
	 * @return the user_emain
	 */
	public String getUser_email() {
		return user_email;
	}


	/**
	 * @param user_emain the user_emain to set
	 */
	public void setUser_email(String user_emain) {
		this.user_email = user_emain;
	}
	
	

	/**
	 * @param user_joind the user_joind to set
	 */
	public void setUser_joind(String user_joind) {
		this.user_joind = user_joind;
	}


	/**
	 * @return the user_joind
	 */
	public String getUser_joind() {
		return user_joind;
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
		UserVO other = (UserVO) obj;
		return Objects.equals(user_id, other.user_id);
	}


	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_phone="
				+ user_phone + ", user_gender=" + user_gender + ", user_emain=" + user_email + ", user_joind="
				+ user_joind + "]";
	}

	
	
	
	
}
