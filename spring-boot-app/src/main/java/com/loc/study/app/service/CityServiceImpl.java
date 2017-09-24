package com.loc.study.app.service;

import com.loc.study.app.module.City;

import com.loc.study.app.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("cityService")
@Transactional
class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;

  public CityServiceImpl(
      CityRepository cityRepository
  ) {
    this.cityRepository = cityRepository;
  }

  @Override
  public Page<City> findCities(CitySearchCriteria criteria, Pageable pageable) {
    Assert.notNull(criteria, "Criteria must not be null");
    String name = criteria.getName();

    if (!StringUtils.hasLength(name)) {
      return this.cityRepository.findAll(null);
    }

    String country = "";
    int splitPos = name.lastIndexOf(",");

    if (splitPos >= 0) {
      country = name.substring(splitPos + 1);
      name = name.substring(0, splitPos);
    }

    return this.cityRepository
        .findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(), country.trim(),
            pageable);
  }

  @Override
  public City getCity(String name, String country) {
    Assert.notNull(name, "Name must not be null");
    Assert.notNull(country, "Country must not be null");
    return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
  }

}
