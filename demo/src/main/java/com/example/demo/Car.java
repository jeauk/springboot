package com.example.demo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Car {
  int tire;
  String model;
  public void run(){
    System.out.println("Car run!!!");
  }
  
}
