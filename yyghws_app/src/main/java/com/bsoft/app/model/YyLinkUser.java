package com.bsoft.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * YyLinkUser entity. @author MyEclipse Persistence Tools
 */

public class YyLinkUser implements java.io.Serializable {

	// Fields

	private Long userid;
	private String username;
	private String phoneno;
	private String email;
	private String idcard;
	private String address;
	private String status;
	private Long yyuserid;
	private Date creatTime;
	private String sex;
	private Date birthday;
	private String cardtype;
	private String nationality;
//	private Set yyUserCards = new HashSet(0);


	// Property accessors

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getYyuserid() {
		return yyuserid;
	}

	public void setYyuserid(Long yyuserid) {
		this.yyuserid = yyuserid;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

//	public Set getYyUserCards() {
//		return this.yyUserCards;
//	}
//
//	public void setYyUserCards(Set yyUserCards) {
//		this.yyUserCards = yyUserCards;
//	}

}