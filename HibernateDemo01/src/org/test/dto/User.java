package org.test.dto;

import java.util.Date;

public class User {

	private Integer id;
	private String username;
	private String pwd;
	private Date birthday;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String username, String pwd, Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", birthday=" + birthday + "]";
	}
	
	
}
