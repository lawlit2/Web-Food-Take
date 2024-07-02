package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 操作user相关数据接口
 */
public interface UserMapper {

    /**
     * 新增
     */
    int insert(User user);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(User user);

    /**
     * 根据ID查询
     */
    User selectById(Integer id);

    /**
     * 查询所有
     */
    List<User> selectAll(User user);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Select("select integral from user where id = #{id}")
    Integer SelectIntegralById(int id);
    @Update("update user set integral = #{integral} where id = #{id}")
    int UpdateIntegralById(@Param("id") int id , @Param("integral") int integral);
    @Delete("update user set integral = NULL where id = #{id}")
    int DeleteIntegralById(int id);
}