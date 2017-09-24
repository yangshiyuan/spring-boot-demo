package com.loc.study.app.mapper;

import com.loc.study.app.module.City;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CityMapper {

  @Insert("insert into city(country, name, state, map) values (#{country}, #{name}, #{state}, #{map});")
  boolean saveCity(
      @Param("country")
          String country,
      @Param("name")
          String name,
      @Param("state")
          String state,
      @Param("map")
          String map);


  @Select("select * from city where id = #{id}")
  City selectCityById(@Param("id") long id);

}
