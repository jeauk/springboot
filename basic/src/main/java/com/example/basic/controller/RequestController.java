package com.example.basic.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.Emp;
import com.example.basic.model.Json;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RequestController {
  @Autowired
  JdbcTemplate jt;

  @GetMapping("req/emp")
  public List<Map<String, Object>> reqEmp(
      @RequestParam(value = "page", defaultValue = "1", required = false) String page,
      @RequestParam(value = "ename", required = false) String ename) {
    int pageNum = Integer.parseInt(page) * 5 - 5;
    String sql = "select * from emp" +
    // " where ename like conat ('%', 'ename', '%')"+
        " where ename like concat('%', '" + ename + "', '%')" +
        " limit " + pageNum + ", 5";
    return jt.queryForList(sql);
  }

  @GetMapping("req/emp2")
  public List<Map<String, Object>> reqEmp2(
    @ModelAttribute("emp") Emp emp
  ){
    int pageNum = Integer.parseInt(emp.getPage()) * 5 - 5;
    String sql = "select * from emp" +
    // " where ename like conat ('%', 'ename', '%')"+
        " where ename like concat('%', '" + emp.getEname() + "', '%')" +
        " limit " + pageNum + ", 5";
    return jt.queryForList(sql);
  }

  @GetMapping("req/param1")
  public String param1(
      @RequestParam("key1") String key1,
      @RequestParam("key2") String key2) {
    return key1 + ", " + key2;
  }

  @GetMapping("req/param2")
  public String param2(@RequestParam Map<String, Object> map) {
    Set<String> keys = map.keySet();
    // 반복자 next() 메소드 호출 -> 다음요소
    Iterator<String> iter = keys.iterator();
    while(iter.hasNext()){
      String key = iter.next();
      String value = (String) map.get(key);
    }
    return map.toString();
  }

  @GetMapping("req/http")
  public String http(HttpServletRequest request) {
    String name = request.getParameter("name");
    String pageNum = request.getParameter("pageNum");
    return name + ", " + pageNum;
  }
  @CrossOrigin
  @GetMapping("req/get")
  public Map<String, String> reqGet(@RequestParam Map<String, String> map){
    return map;
   } 
  @CrossOrigin
  @PostMapping("req/post")
  public Map<String, String> reqPost(@RequestParam Map<String, String> map){
    return map;
   } 
  @CrossOrigin
  @PostMapping("req/json")
  public Json reqJson(@RequestBody Json json){
    return json;
   } 

   @GetMapping("req/data")
   public Map<String, String> reqData(
      @RequestParam Map<String, String> map
    ){
     return map;
    } 

   @GetMapping("req/titanic")
   public List<Map<String, Object>> titanic(){
     String sql = "select * from titanic";
     return jt.queryForList(sql);
   }
 
  }
