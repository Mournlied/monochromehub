package org.mournlied.monochromehub.api.domain.topico;

import jakarta.persistence.*;
import lombok.*;
import org.mournlied.monochromehub.api.domain.curso.Curso;
import org.mournlied.monochromehub.api.domain.usuario.Usuario;

import java.time.OffsetDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "topicId")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topicId;
    
    private String titulo;
    private String mensaje;
    private OffsetDateTime fechaCreacion;
    private Short status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = OffsetDateTime.now();
        this.status = 1;
        this.autor = new Usuario(datosRegistroTopico.autor());
        this.curso = new Curso(datosRegistroTopico.curso());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        this.mensaje = datosActualizarTopico.mensaje();
        this.status = datosActualizarTopico.status();
    }
}
