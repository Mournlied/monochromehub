package org.mournlied.monochromehub.api.domain.curso;

public record DatosRespuestaCurso(String nombre, String categoria
) {public DatosRespuestaCurso(Curso curso){
    this(curso.getNombre(), curso.getCategoria());
}
}
