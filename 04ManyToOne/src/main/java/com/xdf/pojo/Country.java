package com.xdf.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * 国家的实体类
 */
public class Country implements Serializable {
    private int cId; //国家编号
    private String cName;//国家名称

    public Country() {
    }

    public Country(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;
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


    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
