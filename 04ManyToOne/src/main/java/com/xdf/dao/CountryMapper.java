package com.xdf.dao;

import com.xdf.pojo.Country;
import com.xdf.pojo.Provincial;

import java.io.Serializable;

public interface CountryMapper {
    /**
     * 根据省会ID查询对应的省会信息和国家信息
     */
   Provincial selectProvincialByPid(Serializable id);

}
