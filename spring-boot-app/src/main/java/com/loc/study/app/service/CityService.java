package com.loc.study.app.service;


import com.loc.study.app.module.City;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

  Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

  City getCity(String name, String country);

}
