package com.alumnione.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carts")
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    private String checkSum;
}