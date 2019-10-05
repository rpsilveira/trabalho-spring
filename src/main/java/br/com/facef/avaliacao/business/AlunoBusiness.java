package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Aluno;

import java.util.List;

public interface AlunoBusiness {
    List<Aluno> findAll();
    Aluno findById(int id);
    Aluno save(Aluno aluno);
    void deleteById(int id);
}
