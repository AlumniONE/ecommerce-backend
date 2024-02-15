package com.alumnione.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//La anotacion @NoRepositoryBean se usa para indicarle a Spring que esta interface no sera considerada como un bean
@NoRepositoryBean
public interface CrudRepository<T, ID> extends JpaRepository<T, ID> {
}
