package com.xdf.pojo;

import java.io.Serializable;

public class Provincial  implements Serializable{
    private   int  pId; //省会编号
    private   String  pName; //省会名称
    //多个省会对应一个国家
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Provincial(int pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public Provincial() {

    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Provincial{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", country=" + country +
                '}';
    }

    public Provincial(int pId, String pName, Country country) {
        this.pId = pId;
        this.pName = pName;
        this.country = country;
    }
}
