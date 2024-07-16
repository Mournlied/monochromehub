package org.mournlied.monochromehub.api.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cursoId")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cursoId;
    
    private String nombre;
    private String categoria;

    public Curso(DatosRegistroCurso curso) {
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }

    public Curso(DatosPostCurso datos) {
        this.cursoId = datos.cursoId();
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
    }
}
