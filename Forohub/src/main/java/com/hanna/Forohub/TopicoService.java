package com.hanna.Forohub;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    public Topico registrarTopico(Topico topico) {
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(topico.getTitulo(), topico.getMensaje());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("El tópico con el mismo título y mensaje ya existe.");
        }
        return topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public List<Topico> listarTopicosPorCursoYAño(String curso, int year) {
        return topicoRepository.findByCursoAndYear(curso, year);
    }

    public Page<Topico> listarTopicosPaginados(Pageable pageable) {
        return topicoRepository.findAll(pageable);
    }

    @Transactional
    public Topico actualizarTopico(Long id, Topico datosActualizados) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (!topicoExistente.isPresent()) {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }
        Topico topico = topicoExistente.get();
        topico.setTitulo(datosActualizados.getTitulo());
        topico.setMensaje(datosActualizados.getMensaje());
        topico.setAutor(datosActualizados.getAutor());
        topico.setCurso(datosActualizados.getCurso());

        // Verificar si hay duplicados
        Optional<Topico> duplicado = topicoRepository.findByTituloAndMensaje(datosActualizados.getTitulo(), datosActualizados.getMensaje());
        if (duplicado.isPresent() && !duplicado.get().getId().equals(id)) {
            throw new IllegalArgumentException("El tópico con el mismo título y mensaje ya existe.");
        }

        return topicoRepository.save(topico);
    }

    @Transactional
    public void eliminarTopico(Long id) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (!topicoExistente.isPresent()) {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }
        topicoRepository.deleteById(id);
    }
}
