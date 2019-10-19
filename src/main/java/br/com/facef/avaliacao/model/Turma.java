package br.com.facef.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_turma")
public class Turma {

    @Id
    @Column(name = "id_turma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_aluno_turmas",
               joinColumns = @JoinColumn(name = "id_turma"),
               inverseJoinColumns = @JoinColumn(name = "id_aluno"))
    @JsonManagedReference
    private List<Aluno> alunos;

    public Turma() {}

    public Turma(int id, String nome, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
