package com.example.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dao.DemoDao;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.EmpMapper;


@RestController
public class DBController {
  @Autowired
  DemoDao demoDao;

  @GetMapping("/jdbc/demo")
  public List<Map<String, Object>> jdbcDemo() {
    return demoDao.select();
  }

  @Autowired
  DemoMapper demoMapper;
  @Autowired
  EmpMapper empMapper;

  @GetMapping("/mybatis/demo")
  public List<Map<String, Object>> mybatisDemo() {
    return demoMapper.select("scott");
  }
  @GetMapping("/mybatis/emp")
  public List<Map<String, Object>> mybatisEmp(@RequestParam("ename") String ename) {
    return empMapper.select(ename);
  }
  @GetMapping("/mybatis/demo/add")
  public String mybatisDemoAdd(@RequestParam Map<String, Object> map) {
    try{
      demoMapper.insert(map);
    }catch(Exception e){
      return "데이터 추가 실패";
    }
    // int result =  demoMapper.insert(map);
    // if(result == 0){
    //   return "데이터 추가 실패";
    // } 
    return "데이터 추가 성공";
  }
}
  