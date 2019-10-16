package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Turma;

import java.util.List;

public interface TurmaBusiness {
    List<Turma> findAll();
    Turma findById(int id);
    Turma save(Turma turma);
    void deleteById(int id);
}
