package ru.ibs.training.spring.demo8;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ibs.training.spring.demo8.model.Cat;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CatRepositoryTest {

  CatRepository catRepository;

  @Test
  @DisplayName("Cat entity repository works correctly")
  void catEntityRepositoryWorksCorrectlyTest() {
    // given
    // when
    List<Cat> cats = catRepository.findAll();
    assertThat(cats).isNotNull()
        // then
        .hasSize(3);
  }
}
