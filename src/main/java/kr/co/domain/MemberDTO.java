package kr.co.domain;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String birthday;
	private String address;
	private String gender;
	private String email;
	private int phone;
	private String role;
	
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	



	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getPw() {
		return pw;
	}






	public void setPw(String pw) {
		this.pw = pw;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getBirthday() {
		return birthday;
	}






	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public String getGender() {
		return gender;
	}






	public void setGender(String gender) {
		this.gender = gender;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public int getPhone() {
		return phone;
	}






	public void setPhone(int phone) {
		this.phone = phone;
	}






	public String getRole() {
		return role;
	}






	public void setRole(String role) {
		this.role = role;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	public MemberDTO(String id, String pw, String name, String birthday, String address, String gender, String email,
			int phone, String role) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}






	@Override
	public String toString() {
		return "MemberDTO id=" + id + ", name=" + name;
	}

	
	
	

}
