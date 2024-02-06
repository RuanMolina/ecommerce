package br.com.runa.ecommerce.ecommerce.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCreateRequestDTO(
        @NotBlank
        String username,
        @NotBlank
        String password,

        @NotBlank
        @Email
        String email) {
}
