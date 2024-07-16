ALTER TABLE topicos
    ADD CONSTRAINT fk_curso_id FOREIGN KEY (curso_id) REFERENCES cursos (curso_id);