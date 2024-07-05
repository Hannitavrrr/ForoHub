package com.hanna.Forohub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
    
    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.fechaCreacion) = :year")
    List<Topico> findByCursoAndYear(@Param("curso") String curso, @Param("year") int year);

    Page<Topico> findAll(Example<S> pageable);
}

