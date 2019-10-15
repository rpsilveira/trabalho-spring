package br.com.facef.avaliacao.controller;

import br.com.facef.avaliacao.business.ProfessorBusiness;
import br.com.facef.avaliacao.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/professores")
public class ProfessorController {

    private ProfessorBusiness professorBusiness;

    @Autowired
    public ProfessorController(ProfessorBusiness professorBusiness) {
        this.professorBusiness = professorBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessores() {
        return ResponseEntity.ok().body(professorBusiness.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable int id) {
        return ResponseEntity.ok().body(professorBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> insertProfessor(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorBusiness.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable int id, @RequestBody Professor professorDetails) {
        Professor professor = professorBusiness.findById(id);
        professor.setId(id);
        professor.setNome(professorDetails.getNome());
        return ResponseEntity.ok().body(professorBusiness.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> deleteProfessor(@PathVariable int id) {
        professorBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
