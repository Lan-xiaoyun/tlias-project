package com.lan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lan.mapper.EmpExprMapper;
import com.lan.mapper.EmpMapper;
import com.lan.pojo.*;
import com.lan.service.EmpLogService;
import com.lan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;



@Service
public class EmpServiceimpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;
    /**
     * ------------------PageHelper分页查询----------------
     * @param queryParam
     * @return
     * 注意事项：
     *          1.定义的SQL语句结尾不能加分号
     *          2.PageHelper仅仅能对紧跟在其后的第一个查询语句进行分页处理
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam queryParam) {

        //1.设置分页参数
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        //2.执行查询
        List<Emp> emplist = empMapper.list(queryParam);
        //3.解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) emplist;

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    /**
     * 保存员工信息
     * @param emp
     */
    @Transactional
    @Override
    public void save(Emp emp) {
        try {
            //1.保存员工基本信息
            //补全信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            //2.保存员工工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //3.保存员工日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工+"+emp);
            empLogService.insertLog(empLog);
        }


    }

    @Override
    @Transactional
    public void delete(Integer[] ids) {
        try {
            empMapper.deleteBatch(ids);
            empExprMapper.deleteBatch(ids);
        } finally {
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"删除员工id为"+ Arrays.toString(ids));
            empLogService.insertLog(empLog);
        }
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    @Transactional
    public void update(Emp emp) {
        try {
            // 1.更新员工基本信息
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.update(emp);
            // 2.更新员工工作经历（先删除再插入）
            empExprMapper.deleteByEmpId(emp.getId());
            // 3.插入员工工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 4.保存员工日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"更新员工+"+emp);
            empLogService.insertLog(empLog);
        }

    }


}
