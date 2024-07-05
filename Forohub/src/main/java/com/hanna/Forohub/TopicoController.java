package com.hanna.Forohub;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@Valid @RequestBody Topico topico) {
        Topico nuevoTopico = topicoService.registrarTopico(topico);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoService.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/curso/{curso}/year/{year}")
    public ResponseEntity<List<Topico>> listarTopicosPorCursoYAño(@PathVariable String curso, @PathVariable int year) {
        List<Topico> topicos = topicoService.listarTopicosPorCursoYAño(curso, year);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Topico>> listarTopicosPaginados(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Topico> topicos = topicoService.listarTopicosPaginados(pageable);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/primeros-10")
    public ResponseEntity<List<Topico>> listarPrimeros10Topicos() {
        Pageable primerosDiez = PageRequest.of(0, 10, Sort.by("fechaCreacion").ascending());
        Page<Topico> topicos = topicoService.listarTopicosPaginados(primerosDiez);
        return ResponseEntity.ok(topicos.getContent());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico datosActualizados) {
        Topico topicoActualizado = topicoService.actualizarTopico(id, datosActualizados);
        return ResponseEntity.ok(topicoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
