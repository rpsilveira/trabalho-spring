package br.com.facef.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @Column(name = "id_aluno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "alunos")
    @JsonBackReference
    private List<Turma> turmas;

    public Aluno() {}

    public Aluno(int id, String nome) {
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

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
