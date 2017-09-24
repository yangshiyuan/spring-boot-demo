package com.loc.study.app.module;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity对应数据库中一的个表
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {
  //If an entity instance is to be passed by value as a detached object (e.g., through a remote interface),
  //the entity class must implement the Serializable interface.
  private static final long serialVersionUID = 1L;

  //@Id定义了映射到数据库表的主键的属性,一个实体只能有一个属性被映射为主键
  @Id
  @SequenceGenerator(name = "city_generator", sequenceName = "city_sequence", initialValue = 23)
  //generator:表示主键生成器的名称
  @GeneratedValue(generator = "city_generator")
  private Long id;

  //@Column描述了数据库表中该字段的详细定义
  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String state;

  @Column(nullable = false)
  private String country;

  @Column(nullable = false)
  private String map;

}
