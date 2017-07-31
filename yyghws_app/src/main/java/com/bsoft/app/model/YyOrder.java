package com.bsoft.app.model;

import java.util.Date;

/**
 * YyOrder entity. @author MyEclipse Persistence Tools
 */

public class YyOrder implements java.io.Serializable {

	// Fields

	private Long yyid;
	private String HospitalId;
	private String Source;
	private String WorkId;
	private Date OrderTime;
	private String CardId;
	private String CardType;
	private String PatientName;
	private String PatientGender;
	private Date PatientBirthday;
	private String TelePhoneNo;
	private String Address;
	private String SeqCode;
	private String state;
	private String alipayinfo;
	private Byte Price;
	private String deptid;
	private String yktcard;
	private String sbcard;
	private String ylcard;
	private String PatientSex;
	private Date creat_time;
	private Long UserId;
	private String LoginUserCardType; //提交人的账户证件类型
    private String LoginUserIdCard; //提交人的账户证件号码
    private String workdate;
    private String orderdate;     //预约日期（格式：yyyy-MM-dd）    
    private String time;        //预约时间段（格式HH:ss-HH:ss）
    private String doctors;
    private String doctorName;
    private String deptname;
    private String bookingstatus;//1初诊2复诊3其他 
	public String getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	public YyOrder() {
		super();
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctors() {
		return doctors;
	}
	public void setDoctors(String doctors) {
		this.doctors = doctors;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Long getYyid() {
		return yyid;
	}
	public void setYyid(Long yyid) {
		this.yyid = yyid;
	}
	public String getHospitalId() {
		return HospitalId;
	}
	public void setHospitalId(String hospitalId) {
		HospitalId = hospitalId;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getWorkId() {
		return WorkId;
	}
	public void setWorkId(String workId) {
		WorkId = workId;
	}
	public Date getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}
	public String getCardId() {
		return CardId;
	}
	public void setCardId(String cardId) {
		CardId = cardId;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getPatientGender() {
		return PatientGender;
	}
	public void setPatientGender(String patientGender) {
		PatientGender = patientGender;
	}
	public Date getPatientBirthday() {
		return PatientBirthday;
	}
	public void setPatientBirthday(Date patientBirthday) {
		PatientBirthday = patientBirthday;
	}
	public String getTelePhoneNo() {
		return TelePhoneNo;
	}
	public void setTelePhoneNo(String telePhoneNo) {
		TelePhoneNo = telePhoneNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getSeqCode() {
		return SeqCode;
	}
	public void setSeqCode(String seqCode) {
		SeqCode = seqCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAlipayinfo() {
		return alipayinfo;
	}
	public void setAlipayinfo(String alipayinfo) {
		this.alipayinfo = alipayinfo;
	}
	public Byte getPrice() {
		return Price;
	}
	public void setPrice(Byte price) {
		Price = price;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getYktcard() {
		return yktcard;
	}
	public void setYktcard(String yktcard) {
		this.yktcard = yktcard;
	}
	public String getSbcard() {
		return sbcard;
	}
	public void setSbcard(String sbcard) {
		this.sbcard = sbcard;
	}
	public String getYlcard() {
		return ylcard;
	}
	public void setYlcard(String ylcard) {
		this.ylcard = ylcard;
	}
	public Date getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getLoginUserCardType() {
		return LoginUserCardType;
	}
	public void setLoginUserCardType(String loginUserCardType) {
		LoginUserCardType = loginUserCardType;
	}
	public String getLoginUserIdCard() {
		return LoginUserIdCard;
	}
	public void setLoginUserIdCard(String loginUserIdCard) {
		LoginUserIdCard = loginUserIdCard;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getPatientSex() {
		return PatientSex;
	}
	public void setPatientSex(String patientSex) {
		PatientSex = patientSex;
	}
	
}