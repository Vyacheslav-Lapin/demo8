package ru.ibs.training.spring.demo8.model;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.hateoas.MediaTypes.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CatTest {

  MockMvc mockMvc;

  @Test
  @lombok.SneakyThrows
  @DisplayName("Cat controller works correctly")
  void catControllerWorksCorrectlyTest() {
    // given
    mockMvc.perform(get("/cats"))
           .andExpect(status().isOk())
           .andExpect(content().contentType(HAL_JSON_VALUE))
           .andExpect(jsonPath("$.page.totalElements").isNumber())
           .andExpect(jsonPath("$.page.totalElements").value(3));
  }
}
