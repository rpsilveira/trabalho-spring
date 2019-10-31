package br.com.facef.avaliacao.controller;

import br.com.facef.avaliacao.business.TurmaBusiness;
import br.com.facef.avaliacao.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/turmas")
public class TurmaController {

    private TurmaBusiness turmaBusiness;

    @Autowired
    public TurmaController(TurmaBusiness turmaBusiness) {
        this.turmaBusiness = turmaBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurmas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(turmaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaById(@PathVariable int id) {
        return ResponseEntity.ok().body(turmaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Turma> insertTurma(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaBusiness.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable int id, @RequestBody Turma turmaDetails) {
        Turma turma = turmaBusiness.findById(id);
        turma.setId(id);
        turma.setNome(turmaDetails.getNome());
        turma.setCurso(turmaDetails.getCurso());
        return ResponseEntity.ok().body(turmaBusiness.save(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turma> deleteTurma(@PathVariable int id) {
        turmaBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/findByAluno")
    public ResponseEntity<List<Turma>> findByAluno(@RequestParam(value="nome") String nome) {
        return ResponseEntity.ok().body(turmaBusiness.findByAluno(nome));
    }

}
