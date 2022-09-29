package com.lec.project.vo;

import java.util.Objects;

public class CategoryVO {
	
	private String category_code;
	private String category_name;
	
	
	
	
	public CategoryVO() {
		super();
	}

	public CategoryVO(String category_code, String category_name) {
		super();
		this.category_code = category_code;
		this.category_name = category_name;
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
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}

	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category_code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryVO other = (CategoryVO) obj;
		return Objects.equals(category_code, other.category_code);
	}

	@Override
	public String toString() {
		return "CategoryVO [category_code=" + category_code + ", category_name=" + category_name + "]";
	}

	
	
	
}
