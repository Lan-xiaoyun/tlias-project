package com.lan.service;

import com.lan.pojo.Emp;
import com.lan.pojo.EmpQueryParam;
import com.lan.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询员工列表
     * @param queryParam
     * @return PageResult
     */
    PageResult<Emp> page(EmpQueryParam queryParam);

    void save(Emp emp);

    void delete(Integer[] ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    // PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,LocalDate begin,LocalDate end);
}
