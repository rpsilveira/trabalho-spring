package br.com.facef.avaliacao.controller;

import br.com.facef.avaliacao.business.AlunoBusiness;
import br.com.facef.avaliacao.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {

    private AlunoBusiness alunoBusiness;

    @Autowired
    public AlunoController(AlunoBusiness alunoBusiness) {
        this.alunoBusiness = alunoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(alunoBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable int id) {
        return ResponseEntity.ok().body(alunoBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> insertAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoBusiness.save(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable int id, @RequestBody Aluno alunoDetails) {
        Aluno aluno = alunoBusiness.findById(id);
        aluno.setId(id);
        aluno.setNome(alunoDetails.getNome());
        return ResponseEntity.ok().body(alunoBusiness.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable int id) {
        alunoBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
