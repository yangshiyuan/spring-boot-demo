package com.loc.study.test;

import com.loc.study.app.MvcApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created on 2017/4/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MvcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class MvcApplicationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testHelloWorld() {
    ResponseEntity entity = this.restTemplate.getForEntity("/hello", String.class);
    assertThat(entity.getBody()).isEqualTo("Hello World");
    assertThat(entity.getStatusCodeValue()).isEqualTo(200);
  }
}
