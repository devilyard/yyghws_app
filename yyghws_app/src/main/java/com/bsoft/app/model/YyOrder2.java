package com.bsoft.app.model;

import java.util.Date;

public class YyOrder2 {

	private String yyid;
	private String HospitalId;
	private String Source;
	private String WorkId;
	private String CardId;
	private String CardType;
	private String PatientName;
	private String TelePhoneNo;
	private String SeqCode;
	private String state;
	private String deptid;
	private String creat_time;
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
	public String getTelePhoneNo() {
		return TelePhoneNo;
	}
	public void setTelePhoneNo(String telePhoneNo) {
		TelePhoneNo = telePhoneNo;
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
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getYyid() {
		return yyid;
	}
	public void setYyid(String yyid) {
		this.yyid = yyid;
	}
	public String getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}
	
}
