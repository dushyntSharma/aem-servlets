package com.aem.mind.core.models;

public class JDBCData {
	private String firstname;
	private String address;
	private String gender;

	public JDBCData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCData(String firstname, String address, String gender) {
		super();
		this.firstname = firstname;
		this.address = address;
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

}
