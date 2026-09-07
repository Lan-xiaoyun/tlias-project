package com.lan.controller;

import com.lan.pojo.Emp;
import com.lan.pojo.EmpQueryParam;
import com.lan.pojo.PageResult;
import com.lan.pojo.Result;
import com.lan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    /**
     * 获取员工列表
     * @Param pageNum 页码
     * @Param pageSize 每页数量
     * @return 员工列表，总记录数
     */
    @GetMapping
    public Result list(EmpQueryParam queryParam){
        log.info("获取员工列表：{}",queryParam);
        PageResult<Emp> pageResult = empService.page(queryParam);
        return Result.success(pageResult);
    }


    /**
     * 保存员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除员工
     * @param ids
     * @return
     */

    @DeleteMapping
    // 需要注意的是，传入数据方式有两种Interger[] ids;@RequestParam List<Integer> ids;
    public Result delete(Integer[] ids){
        log.info("删除员工：{}", Arrays.toString(ids));
        empService.delete(ids);
        return Result.success();

    }

    /**
     * 数据回显（编辑员工）
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("获取员工：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 修改员工信息
     * @param emp
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工：{}",emp);
        empService.update(emp);
        return Result.success();
    }




}
