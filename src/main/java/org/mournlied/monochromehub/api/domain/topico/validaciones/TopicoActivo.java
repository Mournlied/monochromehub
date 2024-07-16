package org.mournlied.monochromehub.api.domain.topico.validaciones;

import jakarta.validation.ValidationException;
import org.mournlied.monochromehub.api.domain.topico.DatosActualizarTopico;
import org.mournlied.monochromehub.api.domain.topico.TopicoRepository;
import org.mournlied.monochromehub.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoActivo{
        @Autowired
        private TopicoRepository repository;

        public void validar(DatosActualizarTopico datosActualizarTopico) {
            if (datosActualizarTopico.topicId() == null) {
                throw new ValidacionDeIntegridad("Debe ingresar el id del tópico");
            }
            var consultaActivo = repository.findById(datosActualizarTopico.topicId());
            if(consultaActivo.isPresent()){
                var topicoActivo = consultaActivo.get();
                switch (topicoActivo.getStatus()){
                    case 0:
                        throw new ValidationException("El tópico ingresado ha sido eliminado por un(a) moderador(a)");
                    case 1:
                        break;
                    case 2:
                        throw new ValidationException("El tópico ingresado ha sido cerrado por su autor(a)");
                    case 3:
                        throw new ValidationException("El tópico ingresado ha sido cerrado por un(a) moderador(a)");
                    default:
                        throw new ValidationException("El tópico ingresado no se encuentra disponible");
            }
        }
    }
}
