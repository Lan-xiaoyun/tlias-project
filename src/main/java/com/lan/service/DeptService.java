package com.lan.service;

import com.lan.pojo.Dept;

import java.util.List;

public interface DeptService {


    /**
     * 查询全部的部门数据
     * @return
     */
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void addByName(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept getById(Integer id);

    void updateById(Dept dept);
}
