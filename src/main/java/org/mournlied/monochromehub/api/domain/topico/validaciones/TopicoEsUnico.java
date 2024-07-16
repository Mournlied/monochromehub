package org.mournlied.monochromehub.api.domain.topico.validaciones;

import jakarta.validation.ValidationException;
import org.mournlied.monochromehub.api.domain.topico.DatosRegistroTopico;
import org.mournlied.monochromehub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoEsUnico implements ValidadorDeTopicos{
    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DatosRegistroTopico datosRegistroTopico) {
        var tituloConsulta = repository.findTopicByTitulo(datosRegistroTopico.titulo());
        var mensajeConsulta = repository.findTopicByMensaje(datosRegistroTopico.mensaje());
        if (tituloConsulta.isPresent() || mensajeConsulta.isPresent()){
            throw new ValidationException("No estan permitidos los tópicos duplicados");
        }
    }
}
