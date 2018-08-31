package com.xdf.dao;

import com.xdf.pojo.Country;

import java.io.Serializable;

public interface CountryMapper {
    /**
     * 根据国家ID查询国家信息和对应的省会信息
     */
   Country  selectCountryByCid(Serializable id);

}
