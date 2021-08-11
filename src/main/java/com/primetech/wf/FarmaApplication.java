package com.primetech.wf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class FarmaApplication {

  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello! This is farma DB service";
  }

  @RequestMapping("/hello")
  @ResponseBody
  String hello() {
    return "Hello from Hero!";
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
