package com.xdf.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * 国家的实体类
 */
public class Country implements Serializable {
    private int cId; //国家编号
    private String cName;//国家名称
    //一个国家有多个省会   集合属性
    private Set<Provincial> provincials;

    public Country() {
    }

    public Country(int cId, String cName, Set<Provincial> provincials) {
        this.cId = cId;
        this.cName = cName;
        this.provincials = provincials;
    }

    public int getcId() {

        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Set<Provincial> getProvincials() {
        return provincials;
    }

    public void setProvincials(Set<Provincial> provincials) {
        this.provincials = provincials;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", provincials=" + provincials +
                '}';
    }
}
