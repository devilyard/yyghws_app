package com.bsoft.app.model;

import java.util.Date;

/**
 * YyUserAccount entity. @author MyEclipse Persistence Tools
 */

public class YyUserAccount implements java.io.Serializable {

	// Fields

	private String TelePhoneNo;
	private String UserName;
	private String PassWords;
	private String email;
	private String IdCard;
	private String address;
	private Date regdate;
	private Short age;
	private String Gender;
	private String source;
	private Long userid;
	private Date BirthDay;
	private String CardType;
	private Integer Nationality;
	public String getTelePhoneNo() {
		return TelePhoneNo;
	}
	public void setTelePhoneNo(String telePhoneNo) {
		TelePhoneNo = telePhoneNo;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWords() {
		return PassWords;
	}
	public void setPassWords(String passWords) {
		PassWords = passWords;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCard() {
		return IdCard;
	}
	public void setIdCard(String idCard) {
		IdCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Date getBirthDay() {
		return BirthDay;
	}
	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public Integer getNationality() {
		return Nationality;
	}
	public void setNationality(Integer nationality) {
		Nationality = nationality;
	}

	
	
}