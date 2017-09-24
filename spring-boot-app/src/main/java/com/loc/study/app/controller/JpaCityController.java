package com.loc.study.app.controller;


import com.loc.study.app.module.City;
import com.loc.study.app.service.CitySearchCriteria;
import com.loc.study.app.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jpa/city")
public class JpaCityController {

  @Autowired
  private CityService cityService;

  //curl '127.0.0.1:8088/jpa/city/getCity?name=Bath&country=UK'
  @GetMapping(value = "/getCity")
//  @RequestMapping(value = "/getCity", method = RequestMethod.GET)
  //配合@ResponseBody注解，以及HTTP Request Header中的Accept属性，Controller返回的Java对象可以自动被转换成对应的XML或者JSON数据。
  @ResponseBody
  @Transactional(readOnly = true)
  public City getCity(
      @RequestParam(name = "name")
          String name,
      @RequestParam(name = "country")
          String country) {
    return this.cityService.getCity(name, country);
  }


  //根据name和country进行模糊搜索,并且分页
  //curl '127.0.0.1:8088/jpa/city/findCities?name=B,U'
  //curl '127.0.0.1:8088/jpa/city/findCities?name=B,U&page=1&size=2'
  @GetMapping(value = "/findCities")
  @ResponseBody
  @Transactional(readOnly = true)
  public List<City> findCities(
      @RequestParam(name = "name")
          String name,
      @RequestParam(name = "page", required = false, defaultValue = "0")
          int page,
      @RequestParam(name = "size", required = false, defaultValue = "10")
          int size
  ) {
    CitySearchCriteria citySearchCriteria = new CitySearchCriteria(name);
    Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.DESC, "id"));
    return this.cityService.findCities(citySearchCriteria, pageable).getContent();
  }
}
