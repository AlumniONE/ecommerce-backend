package com.alumnione.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerDto(
		
        @NotBlank(message = "First name is required")
        @Size(max = 20, message = "The first name must not exceed 20 characters")
        String firstName,
        
        @NotBlank(message = "Last name is required")
        @Size(max = 20, message = "The last name must not exceed 20 characters")
        String lastName,
        
        @NotBlank(message = "Email is required")
        @Email(message = "This field should be email format")
        @Size(max = 30, message = "The email must not exceed 30 characters")
        String email,
        
        @NotBlank(message = "Password is required")
        @Size(max = 20, message = "The password must not exceed 20 characters")
        String password,
        
        @Size(max = 30, message = "The address must not exceed 30 characters")
        String address,

        @NotNull(message = "Phone number is required")
        String phoneNumber
) {
}
