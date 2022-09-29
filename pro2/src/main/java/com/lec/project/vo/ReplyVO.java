package com.lec.project.vo;

import java.util.Date;
import java.util.Objects;

public class ReplyVO {
	
	private int reply_num ;
	private int pro_num   ;
	private String user_id   ;
	private String content   ;
	private Date reply_date;
	private int re_org    ;
	private int re_ord    ;
	private int re_dep    ;

	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}

	public ReplyVO(int reply_num, int pro_num, String user_id, String content, Date reply_date, int re_org, int re_ord,
			int re_dep) {
		super();
		this.reply_num = reply_num;
		this.pro_num = pro_num;
		this.user_id = user_id;
		this.content = content;
		this.reply_date = reply_date;
		this.re_org = re_org;
		this.re_ord = re_ord;
		this.re_dep = re_dep;
	}

	/**
	 * @return the reply_num
	 */
	public int getReply_num() {
		return reply_num;
	}

	/**
	 * @param reply_num the reply_num to set
	 */
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the reply_date
	 */
	public Date getReply_date() {
		return reply_date;
	}

	/**
	 * @param reply_date the reply_date to set
	 */
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	/**
	 * @return the re_org
	 */
	public int getRe_org() {
		return re_org;
	}

	/**
	 * @param re_org the re_org to set
	 */
	public void setRe_org(int re_org) {
		this.re_org = re_org;
	}

	/**
	 * @return the re_ord
	 */
	public int getRe_ord() {
		return re_ord;
	}

	/**
	 * @param re_ord the re_ord to set
	 */
	public void setRe_ord(int re_ord) {
		this.re_ord = re_ord;
	}

	/**
	 * @return the re_dep
	 */
	public int getRe_dep() {
		return re_dep;
	}

	/**
	 * @param re_dep the re_dep to set
	 */
	public void setRe_dep(int re_dep) {
		this.re_dep = re_dep;
	}


	@Override
	public int hashCode() {
		return Objects.hash(reply_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyVO other = (ReplyVO) obj;
		return reply_num == other.reply_num;
	}
	
	
	@Override
	public String toString() {
		return "ReplyVO [reply_num=" + reply_num + ", pro_num=" + pro_num + ", user_id=" + user_id + ", content="
				+ content + ", reply_date=" + reply_date + ", re_org=" + re_org + ", re_ord=" + re_ord + ", re_dep="
				+ re_dep + "]";
	}
	
	
	
}
