package cn.qyl.ebuy.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	private int id;
	private String userId;
	private String passWord;
	private String name;
	private String province;
	private String city;
	private int sex;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date birthday;
	private String email;
	private String phone;
	private String address;
	private Integer role;
 	private java.util.Date createDate;
	private int activeStatus;
	private String activeCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", passWord="
				+ passWord + ", name=" + name + ", province=" + province
				+ ", city=" + city + ", sex=" + sex + ", birthday=" + birthday
				+ ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", role=" + role + ", createDate=" + createDate
				+ ", activeStatus=" + activeStatus + ", activeCode="
				+ activeCode + "]";
	}
	
	
}
