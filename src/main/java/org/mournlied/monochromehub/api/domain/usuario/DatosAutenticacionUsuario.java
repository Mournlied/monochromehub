package org.mournlied.monochromehub.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        String nombre, 
        @NotBlank
        String password) {
}
