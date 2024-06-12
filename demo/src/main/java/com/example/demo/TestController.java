package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Autowired Car car;

  @GetMapping("/test")
  public String test(){
    car.run();
    return "<h1>테스트 페이지</h1>";
  }
}
