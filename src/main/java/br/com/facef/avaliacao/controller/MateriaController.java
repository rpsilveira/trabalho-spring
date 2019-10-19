package br.com.facef.avaliacao.controller;

import br.com.facef.avaliacao.business.MateriaBusiness;
import br.com.facef.avaliacao.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/materias")
public class MateriaController {

    private MateriaBusiness materiaBusiness;

    @Autowired
    public MateriaController(MateriaBusiness materiaBusiness) {
        this.materiaBusiness = materiaBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(materiaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable int id) {
        return ResponseEntity.ok().body(materiaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Materia> insertMateria(@RequestBody Materia materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaBusiness.save(materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable int id, @RequestBody Materia materiaDetails) {
        Materia materia = materiaBusiness.findById(id);
        materia.setId(id);
        materia.setNome(materiaDetails.getNome());
        materia.setProfessor(materiaDetails.getProfessor());
        return ResponseEntity.ok().body(materiaBusiness.save(materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Materia> deleteMateria(@PathVariable int id) {
        materiaBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
