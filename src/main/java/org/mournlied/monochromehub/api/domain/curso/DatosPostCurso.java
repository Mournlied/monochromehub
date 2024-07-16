package org.mournlied.monochromehub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosPostCurso(
        @NotNull
        Integer cursoId,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
