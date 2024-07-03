package com.example.mapper;

import com.example.entity.Business;
import com.example.entity.Location;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商家相关的数据访问接口
 */
public interface BusinessMapper {

    List<Business> selectAll(Business business);

    int insert(Business business);

    int updateById(Business business);

    int deleteById(Integer id);
    @Select("Select * from business where province = #{province} AND city = #{city}")
    List<Business> SelectBusinessByAddress(String province,String city);

    @Select("SELECT DISTINCT province, city FROM business")
    List<Location> SelectLocation();
}
