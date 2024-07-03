package com.example.mapper;

import com.example.entity.Business;
import com.example.entity.Location;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 商家相关的数据访问接口
 */
public interface BusinessMapper {

    List<Business> selectAll(Business business);

    int insert(Business business);

    int updateById(Business business);

    int deleteById(Integer id);
    @Select("Select * from business where province = #{province} AND city = #{city} AND status = '通过'")
    List<Business> SelectBusinessByAddress(String province,String city);
//每周可配送时间
    @Select("SELECT DISTINCT province, city FROM business where status = '通过'")
    List<Location> SelectLocation();
    @Update("Update business set weeklyDeliveryTime = #{DeliveryTime} where id = #{id}")
    Integer UpdateDeliveryTime(String DeliveryTime,int id);
    @Delete("Update business set weeklyDeliveryTime = NULL where id = #{id}")
    Integer DeleteDeliveryTime(int id);
    @Select("Select weeklyDeliveryTime from business where id = #{id}")
    String SelectDeliveryTime(int id);
//可配送时间段
    @Update("Update business set deliveryTimeWindow = #{TimeWindow} where id = #{id}")
    Integer UpdateTimeWindow(String TimeWindow,int id);
    @Delete("Update business set deliveryTimeWindow = NULL where id = #{id}")
    Integer DeleteTimeWindow(int id);
    @Select("Select deliveryTimeWindow from business where id = #{id}")
    String SelectTimeWindow(int id);
}
