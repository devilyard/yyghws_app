package com.bsoft.app.model;

public class YyHospital implements java.io.Serializable {
	
	private String HospitalId;

    private String HospitalName;

    private String TelephoneNo;

    private String Address;

    private String Information;

    private String LogoUrl;

    private String PictureUrl;

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
   
    public boolean equals(Object obj) {  
        if(obj == null) return false;  
        if(this == obj) return true;  
        if(obj instanceof YyHospital){
        	YyHospital hos=(YyHospital)obj;
        	if(!"".equals(hos.getHospitalId()) && hos.getHospitalId().equals(this.getHospitalId())){
        		return true;
        	}
        }
        return false;  
    }
    
    public int hashCode() {
    	if(!"".equals(this.getHospitalId())){
    		return HospitalId.hashCode();
    	}
    	return super.hashCode();
    }
}