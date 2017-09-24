package com.loc.study.app.controller;

import com.loc.study.app.mapper.CityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2017/5/21.
 */
@Controller
@RequestMapping("/mybatis")
public class MybatisController {

  @Autowired
  private CityMapper cityMapper;

  //http '127.0.0.1:8088/mybatis/saveCity?country=China&name=guangzhou&state=guangdong&map=113.35, 23.12'
  @GetMapping(value = "/saveCity")
  @ResponseBody
  @Transactional
  public boolean saveCity(
      @RequestParam(name = "country")
          String country,
      @RequestParam(name = "name")
          String name,
      @RequestParam(name = "state")
          String state,
      @RequestParam(name = "map")
          String map) {
    return this.cityMapper.saveCity(country, name, state, map);
  }
}
