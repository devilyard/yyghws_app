package com.bsoft.app.model;

import java.util.Date;

public class YyUserLock implements java.io.Serializable{
    private String buuid;

    private String idcard;

    private String kh;

    private String cardtype;

    private Date locktime;

    public String getBuuid() {
        return buuid;
    }

    public void setBuuid(String buuid) {
        this.buuid = buuid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public Date getLocktime() {
        return locktime;
    }

    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }
}