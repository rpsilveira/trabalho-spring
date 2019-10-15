package br.com.facef.avaliacao.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_materia")
public class Materia {

    @Id
    @Column(name = "id_materia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToOne
    @PrimaryKeyJoinColumn
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

}
