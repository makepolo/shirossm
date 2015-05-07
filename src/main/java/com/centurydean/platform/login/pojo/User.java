package com.centurydean.platform.login.pojo;

/**
 * Author：Galo
 * CreateTime：2015年4月28日 下午3:04:46
 * UpdateBy：Galo
 * UpdateTime：2015年4月28日 下午3:04:46
 * Copyright：CenturyDean.com
 * Description：TODO(简单描述一下该文件功能)
 * Comment：TODO(其它说明)
 */
public class User {
	
	private Integer uid;
	private String username;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
}
