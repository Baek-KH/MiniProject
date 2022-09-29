package com.lec.project.vo;

import java.io.Serializable;
import java.util.Objects;

public class CartVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cart_num;
	private String user_id;
	private int pro_num;
	private int pro_count;
	private int pro_price;
	private String pro_name;
	
	public CartVO() {
		super();
	}

	public CartVO(int cart_num, String user_id, int pro_num, int pro_count) {
		super();
		this.cart_num = cart_num;
		this.user_id = user_id;
		this.pro_num = pro_num;
		this.pro_count = pro_count;
	}

	/**
	 * @return the cart_num
	 */
	public int getCart_num() {
		return cart_num;
	}

	/**
	 * @param cart_num the cart_num to set
	 */
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
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
	 * @return the pro_num
	 */
	public int getPro_num() {
		return pro_num;
	}

	/**
	 * @param pro_num the pro_num to set
	 */
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	/**
	 * @return the pro_count
	 */
	public int getPro_count() {
		return pro_count;
	}

	/**
	 * @param pro_count the pro_count to set
	 */
	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cart_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartVO other = (CartVO) obj;
		return cart_num == other.cart_num;
	}

	@Override
	public String toString() {
		return "CartVO [cart_num=" + cart_num + ", user_id=" + user_id + ", pro_num=" + pro_num + ", pro_count="
				+ pro_count + "]";
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	
	
	
}
