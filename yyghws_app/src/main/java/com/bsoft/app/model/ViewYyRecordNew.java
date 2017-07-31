package com.bsoft.app.model;

public class ViewYyRecordNew {

	private String HospitalId;
	
	private String WorkId;
	
	private String SeqCode;
	
	private String OrderDate;
	
	private String OrderTimeRange;
	
	public String getOrderTimeRange() {
		return OrderTimeRange;
	}

	public void setOrderTimeRange(String orderTimeRange) {
		OrderTimeRange = orderTimeRange;
	}
	
	private String CureFlag;

	public String getHospitalId() {
		return HospitalId;
	}

	public void setHospitalId(String hospitalId) {
		HospitalId = hospitalId;
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

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getCureFlag() {
		return CureFlag;
	}

	public void setCureFlag(String cureFlag) {
		CureFlag = cureFlag;
	}
	
	
}
