package com.loc.study.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on 2017/4/26.
 */
@SpringBootApplication
@EnableCaching
public class MvcApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(MvcApplication.class);
    app.run(args);
//    app.run("--value.commonStr=ProgrammerStr");
  }

  @RestController
  public static class HelloWorldController {

    @RequestMapping("/hello")
    public User helloWorld() {
      System.out.println("Hello World");
      return new User("thomas", 30);
    }
  }

  @Data
  @AllArgsConstructor
  public static class User {
    private String name;
    private int age;
  }
}
