package ru.ibs.training.spring.demo8;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ibs.training.spring.demo8.model.Cat;

import java.util.stream.Stream;

@SpringBootApplication
public class Demo8Application {

  public static void main(String[] args) {
    SpringApplication.run(Demo8Application.class, args);
  }

  @Bean
  ApplicationRunner runner(CatRepository catRepository) {
    return __ -> Stream.of("Барсик", "Мурзик", "Матроскин")
        .map(Cat::new)
        .forEach(catRepository::save);
  }
}
