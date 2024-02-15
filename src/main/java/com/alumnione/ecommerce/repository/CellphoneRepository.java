package com.alumnione.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.alumnione.ecommerce.entity.Cellphone;


@Repository
public interface CellphoneRepository extends CrudRepository<Cellphone, Long>{
}