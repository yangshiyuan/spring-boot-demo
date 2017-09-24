package com.loc.study.app.service;

import java.io.Serializable;

import org.springframework.util.Assert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitySearchCriteria implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;
}
