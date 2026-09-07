package com.lan.mapper;

import com.lan.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历
     * @param exprList
     */

    void insertBatch(List<EmpExpr> exprList);

    /**
     * 批量删除员工工作经历
     * @param ids
     */
    void deleteBatch(Integer[] ids);

    @Delete("delete from emp_expr where emp_id =#{empId}")
    void deleteByEmpId(Integer empId);
}
