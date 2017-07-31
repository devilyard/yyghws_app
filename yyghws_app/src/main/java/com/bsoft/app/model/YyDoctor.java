package com.bsoft.app.model;


public class YyDoctor implements java.io.Serializable {
	
    private String HospitalId;

    private String DoctorId;

    private String DoctorName;

    private String DoctorGender;

    private String DoctorRank;

    private String TelephoneNo;

    private Byte WorkRankID;

    private String WorkRank;

    private String DeptId;

    private String DeptName;

    private String Information;

    private String KeyWord;

    private String PictureUrl;

    private Byte Flag;

    private String tag1;

    private String tag2;

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

	public String getTelephoneNo() {
		return TelephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		TelephoneNo = telephoneNo;
	}

	public Byte getWorkRankID() {
		return WorkRankID;
	}

	public void setWorkRankID(Byte workRankID) {
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

	public String getInformation() {
		return Information;
	}

	public void setInformation(String information) {
		Information = information;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}

	public String getPictureUrl() {
		return PictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		PictureUrl = pictureUrl;
	}

	public Byte getFlag() {
		return Flag;
	}

	public void setFlag(Byte flag) {
		Flag = flag;
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
    
    public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof YyDoctor))
			return false;
		YyDoctor castOther = (YyDoctor) other;

		return ((this.getHospitalId() == castOther.getHospitalId()) || (this
				.getHospitalId() != null && castOther.getHospitalId() != null && this
				.getHospitalId().equals(castOther.getHospitalId())))
				&& ((this.getDoctorId() == castOther.getDoctorId()) || (this
						.getDoctorId() != null
						&& castOther.getDoctorId() != null && this
						.getDoctorId().equals(castOther.getDoctorId())))
				&& ((this.getDeptId() == castOther.getDeptId()) || (this
						.getDeptId() != null && castOther.getDeptId() != null && this
						.getDeptId().equals(castOther.getDeptId())))
				&& ((this.getDoctorName() == castOther.getDoctorName()) || (this
						.getDoctorName() != null
						&& castOther.getDoctorName() != null && this
						.getDoctorName().equals(castOther.getDoctorName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getHospitalId() == null ? 0 : this.getHospitalId()
						.hashCode());
		result = 37 * result
				+ (getDoctorId() == null ? 0 : this.getDoctorId().hashCode());
		result = 37 * result
				+ (getDeptId() == null ? 0 : this.getDeptId().hashCode());
		result = 37
				* result
				+ (getDoctorName() == null ? 0 : this.getDoctorName()
						.hashCode());
		return result;
	}
}