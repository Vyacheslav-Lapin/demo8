package ru.ibs.training.spring.demo8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@SuppressWarnings({"com.haulmont.jpb.LombokDataInspection",
                   "com.intellij.jpb.LombokDataInspection",
                   "com.haulmont.ampjpb.LombokDataInspection"})

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Cat {

  @Id
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version
  int version;

  @NonNull
  String name;
  @Override
  @SuppressWarnings("java:S2097")
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    Cat cat = (Cat) o;
    return getId() != null && Objects.equals(getId(), cat.getId());
  }
  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
  }
}
