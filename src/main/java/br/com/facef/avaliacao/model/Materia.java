package br.com.facef.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_materia")
public class Materia {

    @Id
    @Column(name = "id_materia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "materias")
    @JsonBackReference
    private List<Curso> cursos;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Materia() {}

    public Materia(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
