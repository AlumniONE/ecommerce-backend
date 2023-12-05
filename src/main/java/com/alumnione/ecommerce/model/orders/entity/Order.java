package com.alumnione.ecommerce.model.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Orders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_order")
  private Long orderId;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "order_status")
  private String orderStatus;

  @Column(name = "order_created_at")
  private String orderCreatedAt;

}
