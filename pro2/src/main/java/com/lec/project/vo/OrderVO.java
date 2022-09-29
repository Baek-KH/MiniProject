package com.lec.project.vo;

import java.util.Objects;

public class OrderVO {
	
	private int order_num;
	private String user_id;
	private String order_date;
	private String order_addr1;
	private String order_addr2;
	private String order_addr3;
	private String order_name;
	private String order_phone;
	private int total_price;


	public OrderVO() {
		// TODO Auto-generated constructor stub
	}

	public OrderVO(int order_num, String user_id, String order_date, String order_addr1, String order_addr2,
			String order_addr3, String order_name, String order_phone, int total_price ) {
		super();
		this.order_num = order_num;
		this.user_id = user_id;
		this.order_date = order_date;
		this.order_addr1 = order_addr1;
		this.order_addr2 = order_addr2;
		this.order_addr3 = order_addr3;
		this.order_name = order_name;
		this.order_phone = order_phone;
		this.total_price = total_price;
	
	}

	/**
	 * @return the order_num
	 */
	public int getOrder_num() {
		return order_num;
	}

	/**
	 * @param order_num the order_num to set
	 */
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
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
	 * @return the order_date
	 */
	public String getOrder_date() {
		return order_date;
	}

	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	/**
	 * @return the order_addr1
	 */
	public String getOrder_addr1() {
		return order_addr1;
	}

	/**
	 * @param order_addr1 the order_addr1 to set
	 */
	public void setOrder_addr1(String order_addr1) {
		this.order_addr1 = order_addr1;
	}

	/**
	 * @return the order_addr2
	 */
	public String getOrder_addr2() {
		return order_addr2;
	}

	/**
	 * @param order_addr2 the order_addr2 to set
	 */
	public void setOrder_addr2(String order_addr2) {
		this.order_addr2 = order_addr2;
	}

	/**
	 * @return the order_addr3
	 */
	public String getOrder_addr3() {
		return order_addr3;
	}

	/**
	 * @param order_addr3 the order_addr3 to set
	 */
	public void setOrder_addr3(String order_addr3) {
		this.order_addr3 = order_addr3;
	}

	/**
	 * @return the order_name
	 */
	public String getOrder_name() {
		return order_name;
	}

	/**
	 * @param order_name the order_name to set
	 */
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	/**
	 * @return the order_phone
	 */
	public String getOrder_phone() {
		return order_phone;
	}

	/**
	 * @param order_phone the order_phone to set
	 */
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

	/**
	 * @return the total_price
	 */
	public int getTotal_price() {
		return total_price;
	}

	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}



	@Override
	public int hashCode() {
		return Objects.hash(order_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		return order_num == other.order_num;
	}

	@Override
	public String toString() {
		return "OrderVO [order_num=" + order_num + ", user_id=" + user_id + ", order_date=" + order_date
				+ ", order_addr1=" + order_addr1 + ", order_addr2=" + order_addr2 + ", order_addr3=" + order_addr3
				+ ", order_name=" + order_name + ", order_phone=" + order_phone + ", total_price=" + total_price
				+ "]";
	}
	
	
	
	
	
	
}



