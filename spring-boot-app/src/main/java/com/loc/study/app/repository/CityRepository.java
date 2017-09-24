package com.loc.study.app.repository;


import com.loc.study.app.module.City;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface CityRepository extends Repository<City, Long> {

  // Returns all entities.
  Page<City> findAll(Pageable pageable);

  // ... where UPPER(x.name) like UPPER(?1) and UPPER(x.country) like UPPER(?2)
  Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name, String country,
      Pageable pageable);

  // ... where x.name like ?1 and x.country like ?2
  City findByNameAndCountryAllIgnoringCase(String name, String country);

}
