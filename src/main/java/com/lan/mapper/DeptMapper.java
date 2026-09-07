package com.lan.mapper;

import com.lan.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询全部的部门数据
     * @return
     */
    //方式1：使用@Results注解
        // @Results({
        //         @Result(column = "create_time",property = "createTime"),
        //         @Result(column = "update_time",property = "updateTime")
        // })
    @Select("select id,name,create_time,update_time from dept order by update_time desc;")
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},now(),now())")
    void addByName(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Select("select id,name,create_time,update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门
     * @param dept
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
