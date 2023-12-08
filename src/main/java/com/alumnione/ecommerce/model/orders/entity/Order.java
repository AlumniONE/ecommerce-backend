package com.alumnione.ecommerce.model.orders.entity;

import com.alumnione.ecommerce.model.user.entity.User;

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

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id_user")
  private User user;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "order_status")
  private String orderStatus;

  @Column(name = "order_created_at")
  private String orderCreatedAt;
}
