package com.example.sinup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MethodController {

  @GetMapping("req/signup")
  public String signup(){
    return "signup";
  }
  
}
