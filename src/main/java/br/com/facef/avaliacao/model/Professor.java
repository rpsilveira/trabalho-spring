package br.com.facef.avaliacao.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @Column(name = "id_professor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Professor() {}

    public Professor(int id, String nome) {
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
