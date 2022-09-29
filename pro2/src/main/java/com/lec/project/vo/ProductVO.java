package com.lec.project.vo;

import java.util.Date;
import java.util.Objects;

public class ProductVO extends CategoryVO {
	
	private int pro_num       ;
	private String category_code ;
	private String pro_name      ;
	private int pro_price     ;
	private int pro_stock     ;
	private String pro_desc      ;
	private Date pro_date      ;
	private int pro_hit       ;
	private String pro_img       ;

	
	public ProductVO() {
		// TODO Auto-generated constructor stub
	}


	public ProductVO(int pro_num, String category_code, String pro_name, int pro_price, int pro_stock, String pro_desc,
			Date pro_date, int pro_hit, String pro_img) {
		super();
		this.pro_num = pro_num;
		this.category_code = category_code;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_stock = pro_stock;
		this.pro_desc = pro_desc;
		this.pro_date = pro_date;
		this.pro_hit = pro_hit;
		this.pro_img = pro_img;
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
	 * @return the category_code
	 */
	public String getCategory_code() {
		return category_code;
	}


	/**
	 * @param category_code the category_code to set
	 */
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}


	/**
	 * @return the pro_name
	 */
	public String getPro_name() {
		return pro_name;
	}


	/**
	 * @param pro_name the pro_name to set
	 */
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
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
	 * @return the pro_stock
	 */
	public int getPro_stock() {
		return pro_stock;
	}


	/**
	 * @param pro_stock the pro_stock to set
	 */
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}


	/**
	 * @return the pro_desc
	 */
	public String getPro_desc() {
		return pro_desc;
	}


	/**
	 * @param pro_desc the pro_desc to set
	 */
	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}


	/**
	 * @return the pro_date
	 */
	public Date getPro_date() {
		return pro_date;
	}


	/**
	 * @param pro_date the pro_date to set
	 */
	public void setPro_date(Date pro_date) {
		this.pro_date = pro_date;
	}


	/**
	 * @return the pro_hit
	 */
	public int getPro_hit() {
		return pro_hit;
	}


	/**
	 * @param pro_hit the pro_hit to set
	 */
	public void setPro_hit(int pro_hit) {
		this.pro_hit = pro_hit;
	}


	/**
	 * @return the pro_img
	 */
	public String getPro_img() {
		return pro_img;
	}


	/**
	 * @param pro_img the pro_img to set
	 */
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}


	@Override
	public int hashCode() {
		return Objects.hash(pro_num);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVO other = (ProductVO) obj;
		return pro_num == other.pro_num;
	}


	@Override
	public String toString() {
		return "ProductVO [pro_num=" + pro_num + ", category_code=" + category_code + ", pro_name=" + pro_name
				+ ", pro_price=" + pro_price + ", pro_stock=" + pro_stock + ", pro_desc=" + pro_desc + ", pro_date="
				+ pro_date + ", pro_hit=" + pro_hit + ", pro_img=" + pro_img + "]";
	}
	
	
	
	
}
