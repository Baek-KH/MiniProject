package com.lec.project.vo;

import java.util.Objects;

public class Order_detailVO extends ProductVO{
	
	private int order_num;
	private int pro_num	;
	private int  pro_count;
	private int  pro_price;
	private String  order_check	;
	
	public Order_detailVO() {
		// TODO Auto-generated constructor stub
	}

	public Order_detailVO(int order_num, int pro_num, int pro_count, int pro_price, String order_check) {
		super();
		this.order_num = order_num;
		this.pro_num = pro_num;
		this.pro_count = pro_count;
		this.pro_price = pro_price;
		this.order_check = order_check;
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

	/**
	 * @return the pro_price
	 */
	public int getPro_price() {
		return pro_price;
	}

	/**
	 * @param pro_price the pro_price to set
	 */
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	/**
	 * @return the order_check
	 */
	public String getOrder_check() {
		return order_check;
	}

	/**
	 * @param order_check the order_check to set
	 */
	public void setOrder_check(String order_check) {
		this.order_check = order_check;
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
		Order_detailVO other = (Order_detailVO) obj;
		return order_num == other.order_num;
	}

	@Override
	public String toString() {
		return "Order_detailVO [order_num=" + order_num + ", pro_num=" + pro_num + ", pro_count=" + pro_count
				+ ", pro_price=" + pro_price + ", order_check=" + order_check + "]";
	}
	
	
	

}
