package org.mournlied.monochromehub.api.domain.topico;

import org.mournlied.monochromehub.api.domain.curso.CursoRepository;
import org.mournlied.monochromehub.api.domain.topico.validaciones.TopicoActivo;
import org.mournlied.monochromehub.api.domain.topico.validaciones.TopicoEsUnico;
import org.mournlied.monochromehub.api.domain.usuario.UsuarioRepository;
import org.mournlied.monochromehub.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicosService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoEsUnico unico;
    @Autowired
    private TopicoActivo activo;

    public DatosRespuestaTopico crear(DatosRegistroTopico datosRegistroTopico){

        unico.validar(datosRegistroTopico);

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));

        return new DatosRespuestaTopico(topico);

    }
    
    public DatosRespuestaTopico actualizar(DatosActualizarTopico datosActualizarTopico){
        if (datosActualizarTopico.topicId() != null && topicoRepository.findById(datosActualizarTopico.topicId()).isEmpty()){
            throw new ValidacionDeIntegridad("No fue posible encontrar el tópico ingresado");
        }
        activo.validar(datosActualizarTopico);
        var topico = topicoRepository.findById(datosActualizarTopico.topicId()).get();
        topico.actualizarDatos(datosActualizarTopico);
        return new DatosRespuestaTopico(topico);
    }
}