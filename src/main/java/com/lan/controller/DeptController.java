package com.lan.controller;

import com.lan.pojo.Dept;
import com.lan.pojo.Result;
import com.lan.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {


    @Autowired
    private DeptService deptService;

//    @RequestMapping(value ="/depts",method = RequestMethod.GET)

    /**
     * 查询全部的部门数据
     * @return
     */
    @GetMapping
    public Result list(){
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除部门id为: {}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加部门
     */
    @PostMapping
    public Result addByName(@RequestBody Dept dept){
        log.info("添加部门名称为: {}",dept.getName());
        deptService.addByName(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     */
       @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询部门id为: {}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 更新部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门id为: {}",dept.getId());
        deptService.updateById(dept);
        System.out.println(dept);
        return Result.success();
    }


}
