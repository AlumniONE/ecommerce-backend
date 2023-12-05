package com.alumnione.ecommerce.model.user.repository;

import com.alumnione.ecommerce.model.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
