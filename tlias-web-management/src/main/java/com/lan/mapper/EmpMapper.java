package com.lan.mapper;


import com.lan.pojo.Emp;
import com.lan.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

    // // -----------原始分页查询实现----------------
    // /**
    //  * 查询员工总数
    //  * @return
    //  */
    // @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    // public Long count();
    //
    // /**
    //  * 分页查询员工列表
    //  * @return
    //  */
    // @Select("select e.name,e.gender,e.image,d.name deptName,e.job,e.entry_date,e.update_time from emp e left join dept d on e.dept_id=d.id " +
    //         "order by e.update_time desc limit #{start},#{pageSize}")
    // public List<Emp> list(Integer start, Integer pageSize);

    // @Select("select e.name,e.gender,e.image,d.name deptName,e.job,e.entry_date,e.update_time from emp e left join dept d on e.dept_id=d.id " +
    //         "order by e.update_time desc")
    // public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    public List<Emp> list(EmpQueryParam queryParam);

    /**
     * 插入员工基本信息
         * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "    values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteBatch(Integer[] ids);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    // @Select("select e.username,e.name,e.gender,e.phone,e.job,e.salary,d.name,e.entry_date,image from emp e join dept d on e.dept_id = d.id where e.id = #{id}")
    Emp getById(Integer id);

    // @Select("select e.name,e.gender,e.image,d.name deptName,e.job,e.entry_date,e.update_time from emp e left join dept d on e.dept_id=d.id " +
    //         "where e.name like #{name} and gender = 1 and e.entry_date between #{begin} and #{end} " +
    //         "order by e.update_time desc")
    // public List<Emp> list1(name,begin,end);
    /**
     * 更新员工基本信息
     * @param emp
     */
    void update(Emp emp);

}
