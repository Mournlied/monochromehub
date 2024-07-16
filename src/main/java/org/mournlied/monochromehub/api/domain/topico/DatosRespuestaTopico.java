package org.mournlied.monochromehub.api.domain.topico;

import org.mournlied.monochromehub.api.domain.curso.DatosRespuestaCurso;
import org.mournlied.monochromehub.api.domain.usuario.DatosRespuestaUsuario;

import java.time.OffsetDateTime;

public record DatosRespuestaTopico(
        Integer topicId,
        String titulo,
        String mensaje,
        OffsetDateTime fechaCreacion,
        Short status,
        DatosRespuestaUsuario autor,
        DatosRespuestaCurso curso
) {
    public DatosRespuestaTopico(Topico topico){
        this(
                topico.getTopicId(),
                topico.getTitulo(), 
                topico.getMensaje(), 
                topico.getFechaCreacion(),
                topico.getStatus(), 
                new DatosRespuestaUsuario(topico.getAutor()), 
                new DatosRespuestaCurso(topico.getCurso()));
    }
}
