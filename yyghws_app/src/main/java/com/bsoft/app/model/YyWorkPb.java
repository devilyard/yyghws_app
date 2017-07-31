package com.bsoft.app.model;

import java.util.Date;

public class YyWorkPb implements java.io.Serializable {
	
    private String HospitalId;

    private String WorkId;

    private Date WorkDate;

    private Integer PeriodCode;

    private String StartTime;

    private String EndTime;

    private String DoctorId;

    private String DoctorName;

    private String DoctorGender;

    private String DoctorRank;

    private Integer WorkRankID;

    private String WorkRank;

    private String DeptId;

    private String DeptName;

    private Double Price;

    private Integer OrderFee;

    private String AdmitAddress;

    private Integer OrderCount;

    private String reason;

    private String suggestworkid;

    private Integer flag;

    private String tag1;

    private String tag2;
    
    private Integer AvailableCount;//剩余可预约数 数据库remain字段
    
    private String OrderNumbers;
    
    private Integer version;
    
    public YyWorkPb(){
    	
    }
    
    public YyWorkPb(String HospitalId, String WorkId, Date WorkDate, Integer OrderCount, Integer AvailableCount, String OrderNumbers){
    	this.HospitalId = HospitalId;
    	this.WorkId = WorkId;
    	this.WorkDate = WorkDate;
    	this.OrderCount = OrderCount;
    	this.AvailableCount = AvailableCount;
    	this.OrderNumbers = OrderNumbers;
    }

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

	public Date getWorkDate() {
		return WorkDate;
	}

	public void setWorkDate(Date workDate) {
		WorkDate = workDate;
	}

	public Integer getPeriodCode() {
		return PeriodCode;
	}

	public void setPeriodCode(Integer periodCode) {
		PeriodCode = periodCode;
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

	public String getDoctorGender() {
		return DoctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		DoctorGender = doctorGender;
	}

	public String getDoctorRank() {
		return DoctorRank;
	}

	public void setDoctorRank(String doctorRank) {
		DoctorRank = doctorRank;
	}

	public Integer getWorkRankID() {
		return WorkRankID;
	}

	public void setWorkRankID(Integer workRankID) {
		WorkRankID = workRankID;
	}

	public String getWorkRank() {
		return WorkRank;
	}

	public void setWorkRank(String workRank) {
		WorkRank = workRank;
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

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Integer getOrderFee() {
		return OrderFee;
	}

	public void setOrderFee(Integer orderFee) {
		OrderFee = orderFee;
	}

	public String getAdmitAddress() {
		return AdmitAddress;
	}

	public void setAdmitAddress(String admitAddress) {
		AdmitAddress = admitAddress;
	}

	public Integer getOrderCount() {
		return OrderCount;
	}

	public void setOrderCount(Integer orderCount) {
		OrderCount = orderCount;
	}

	public Integer getAvailableCount() {
		return AvailableCount;
	}

	public void setAvailableCount(Integer availableCount) {
		AvailableCount = availableCount;
	}

	public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSuggestworkid() {
        return suggestworkid;
    }

    public void setSuggestworkid(String suggestworkid) {
        this.suggestworkid = suggestworkid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

	public String getOrderNumbers() {
		return OrderNumbers;
	}

	public void setOrderNumbers(String orderNumbers) {
		OrderNumbers = orderNumbers;
	}
    
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof YyWorkPb))
			return false;
		YyWorkPb castOther = (YyWorkPb) other;

		return ((this.getHospitalId() == castOther.getHospitalId()) || (this
				.getHospitalId() != null && castOther.getHospitalId() != null && this
				.getHospitalId().equals(castOther.getHospitalId())))
				&& ((this.getWorkId() == castOther.getWorkId()) || (this
						.getWorkId() != null && castOther.getWorkId() != null && this
						.getWorkId().equals(castOther.getWorkId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getHospitalId() == null ? 0 : this.getHospitalId()
						.hashCode());
		result = 37 * result
				+ (getWorkId() == null ? 0 : this.getWorkId().hashCode());
		return result;
	}
}