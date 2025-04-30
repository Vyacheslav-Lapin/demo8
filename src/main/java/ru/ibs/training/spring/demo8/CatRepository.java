package ru.ibs.training.spring.demo8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ibs.training.spring.demo8.model.Cat;

import java.util.UUID;

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, UUID> {
}
