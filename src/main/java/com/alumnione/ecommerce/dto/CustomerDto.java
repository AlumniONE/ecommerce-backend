package com.alumnione.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record CustomerDto(
		Long id,

        @NotEmpty(message = "This property cannot be empty or null")
        @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must be a string")
        @Size(min =3, max = 100, message = "The first name must not exceed 20 characters")
        String firstName,

        @NotEmpty(message = "This property cannot be empty or null")
        @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must be a string")
        @Size(min = 3, max = 100, message = "The last name must not exceed 20 characters")
        String lastName,

        @NotEmpty(message = "The e-mail field must no be empty")
        @Email(message = "This field should be email format")
        String email,

        //Checks that a password has a minimum of
        // 6 characters, at least 1 uppercase letter, 1 lowercase letter, and 1 number with no spaces.
//        @Pattern(regexp = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$\n",
//        message = "Safe Password that allow only with a number, a lowercase, a uppercase, and a special character")
        @NotNull(message = "Password is required")
        @NotEmpty(message = "The password field must no be empty")
        @Size(min =8, max = 60, message = "The password must not exceed 20 characters")
        String password,

        @Size(min = 3, max = 100, message = "The address must not exceed 30 characters")
        String address,

        @NotEmpty(message = "The phone number field must no be empty")
        @Pattern(regexp = "[0-9]+")
        String phoneNumber
) {
}
