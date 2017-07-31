package com.bsoft.app.model;

public class YyDept implements java.io.Serializable {
	
    private String HospitalId;
    
    private String HospitalName;

    private String DeptId;

    private String DeptName;

    private String ParentId;

    private String ParentName;

    private String TelephoneNo;

    private String Address;

    private String Information;

    private String KeyWord;

    private String LogoUrl;

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

	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
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

	public String getParentId() {
		return ParentId;
	}

	public void setParentId(String parentId) {
		ParentId = parentId;
	}

	public String getParentName() {
		return ParentName;
	}

	public void setParentName(String parentName) {
		ParentName = parentName;
	}

	public String getTelephoneNo() {
		return TelephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		TelephoneNo = telephoneNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public String getLogoUrl() {
		return LogoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		LogoUrl = logoUrl;
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
		if (!(other instanceof YyDept))
			return false;
		YyDept castOther = (YyDept) other;

		return ((this.getHospitalId() == castOther.getHospitalId()) || (this
				.getHospitalId() != null && castOther.getHospitalId() != null && this
				.getHospitalId().equals(castOther.getHospitalId())))
				&& ((this.getDeptId() == castOther.getDeptId()) || (this
						.getDeptId() != null && castOther.getDeptId() != null && this
						.getDeptId().equals(castOther.getDeptId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getHospitalId() == null ? 0 : this.getHospitalId()
						.hashCode());
		result = 37 * result
				+ (getDeptId() == null ? 0 : this.getDeptId().hashCode());
		return result;
	}
    
}