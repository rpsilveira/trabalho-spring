package br.com.facef.avaliacao.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_curso")
public class Curso {

    @Id
    @Column(name = "id_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    public Curso() {}

    public Curso(int id, String nome) {
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

}
