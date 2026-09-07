package com.lan.service.impl;

import com.lan.mapper.EmpMapper;
import com.lan.pojo.JobOption;
import com.lan.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceimpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        //调取mapper获取数据
        List<Map<String, Object>> maps = empMapper.countEmpJobData();
        //组装结果
        List<Object> jobList = maps.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = maps.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }
}
