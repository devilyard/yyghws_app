package com.bsoft.app.model;

public class YyReturnData {

	private String yyid;
	private String HospitalId;
	private String Source;
	private String WorkId;
	private String OrderTime;
	private String CardId;
	private String CardType;
	private String PatientName;
	private String PatientGender;
	private String TelePhoneNo;
	private String Address;
	private String SeqCode;
	private String deptid;
	private String creat_time;
	private String LoginUserCardType;
	private String LoginUserIdCard;
	private String doctors;
	private String doctorName;
	private String time;
	private String deptname;
	private String orderdate;
	private String PeriodCode;
	public String getYyid() {
		return yyid;
	}
	public void setYyid(String yyid) {
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
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
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
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
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
	public String getDoctors() {
		return doctors;
	}
	public void setDoctors(String doctors) {
		this.doctors = doctors;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getPeriodCode() {
		return PeriodCode;
	}
	public void setPeriodCode(String periodCode) {
		PeriodCode = periodCode;
	}
	public YyReturnData() {
		super();
	}
	public YyReturnData(String hospitalId, String source, String workId, String cardId, String cardType) {
		super();
		HospitalId = hospitalId;
		Source = source;
		WorkId = workId;
		CardId = cardId;
		CardType = cardType;
	}
	
}
