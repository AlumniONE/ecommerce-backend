package com.alumnione.ecommerce.model.cellphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alumnione.ecommerce.model.cellphone.entity.Cellphone;


@Repository
public interface CellphoneRepository extends JpaRepository<Cellphone, Long>{
}