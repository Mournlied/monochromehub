package org.mournlied.monochromehub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Integer topicId,
        @NotBlank
        String mensaje,
        @NotNull
        Short status) {
}
