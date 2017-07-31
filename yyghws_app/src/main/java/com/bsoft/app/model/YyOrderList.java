package com.bsoft.app.model;

import java.util.Date;

public class YyOrderList implements java.io.Serializable {
	private Long yyid;
	
    private String HospitalId;
    
    private String DoctorId;

    private String DoctorName;
    
    private String DeptId;

    private String DeptName;

    private String WorkId;
    
    private String SeqCode;

    private Date WorkDate;

    private String StartTime;

    private String EndTime;

    private Integer AppointType;//预约类型：1普通 2专家

    private String AppointSource;//预约来源：预定来源，1 电话，2 Web，3 Wap, 4其他

    private Date AppointTime;

    private String AppointStatus;//预约状态：1 已成功 2已就诊 3已取消 4爽约 5已支付 6已评价,7 挂号不就诊 8 退号

    private Integer AppointPay;//预约费用
    
    private String IdCard;
    
	private String CardType;

	public String getHospitalId() {
		return HospitalId;
	}

	public void setHospitalId(String hospitalId) {
		HospitalId = hospitalId;
	}

	public String getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getDeptId() {
		return DeptId;
	}

	public void setDeptId(String deptId) {
		DeptId = deptId;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getWorkId() {
		return WorkId;
	}

	public void setWorkId(String workId) {
		WorkId = workId;
	}

	public String getSeqCode() {
		return SeqCode;
	}

	public void setSeqCode(String seqCode) {
		SeqCode = seqCode;
	}

	public Date getWorkDate() {
		return WorkDate;
	}

	public void setWorkDate(Date workDate) {
		WorkDate = workDate;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public Integer getAppointType() {
		return AppointType;
	}

	public void setAppointType(Integer appointType) {
		AppointType = appointType;
	}

	public String getAppointSource() {
		return AppointSource;
	}

	public void setAppointSource(String appointSource) {
		AppointSource = appointSource;
	}

	public Date getAppointTime() {
		return AppointTime;
	}

	public void setAppointTime(Date appointTime) {
		AppointTime = appointTime;
	}

	public String getAppointStatus() {
		return AppointStatus;
	}

	public void setAppointStatus(String appointStatus) {
		AppointStatus = appointStatus;
	}

	public Integer getAppointPay() {
		return AppointPay;
	}

	public void setAppointPay(Integer appointPay) {
		AppointPay = appointPay;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public Long getYyid() {
		return yyid;
	}

	public void setYyid(Long yyid) {
		this.yyid = yyid;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}
	
	
	
}