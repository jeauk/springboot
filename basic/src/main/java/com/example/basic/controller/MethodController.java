package com.example.basic.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
  @PostMapping("req/post2")
  public String post() {
    return "POST";
  }

}
