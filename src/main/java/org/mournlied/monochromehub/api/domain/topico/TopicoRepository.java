package org.mournlied.monochromehub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TopicoRepository extends JpaRepository<Topico,Integer> {
    Page<Topico> findByStatusTrue(Pageable paginacion);

    Optional<Topico> findTopicByTitulo(String titulo);

    Optional<Topico> findTopicByMensaje(String mensaje);
}
