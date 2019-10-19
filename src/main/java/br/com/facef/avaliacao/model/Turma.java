package br.com.facef.avaliacao.model;

import javax.persistence.*;

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

}