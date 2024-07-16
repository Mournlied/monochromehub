package org.mournlied.monochromehub.api.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mournlied.monochromehub.api.domain.curso.DatosPostCurso;
import org.mournlied.monochromehub.api.domain.usuario.DatosPostUsuario;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        DatosPostUsuario autor,
        @NotNull
        @Valid
        DatosPostCurso curso) {
}
