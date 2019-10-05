package br.com.facef.avaliacao.controller;

import br.com.facef.avaliacao.business.CursoBusiness;
import br.com.facef.avaliacao.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cursos")
public class CursoController {

    private CursoBusiness cursoBusiness;

    @Autowired
    public CursoController(CursoBusiness cursoBusiness) {
        this.cursoBusiness = cursoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        return ResponseEntity.ok().body(cursoBusiness.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable int id) {
        return ResponseEntity.ok().body(cursoBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Curso> insertCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoBusiness.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable int id, @RequestBody Curso cursoDetails) {
        Curso curso = cursoBusiness.findById(id);
        curso.setId(id);
        curso.setNome(cursoDetails.getNome());
        return ResponseEntity.ok().body(cursoBusiness.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deleteCurso(@PathVariable int id) {
        cursoBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
