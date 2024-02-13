package com.alumnione.ecommerce.dto;


import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record CartDto(LocalDateTime lastUpdated){}