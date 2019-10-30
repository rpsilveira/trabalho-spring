package br.com.facef.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_turma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "turmas")
    @OrderBy("nome")
    @JsonIgnoreProperties("id")
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
