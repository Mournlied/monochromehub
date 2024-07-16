package org.mournlied.monochromehub.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosPostUsuario(
        @NotNull
        Integer userId,
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
