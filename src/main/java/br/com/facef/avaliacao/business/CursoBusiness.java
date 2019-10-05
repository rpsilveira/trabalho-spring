package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Curso;

import java.util.List;

public interface CursoBusiness {
    List<Curso> findAll();
    Curso findById(int id);
    Curso save(Curso curso);
    void deleteById(int id);
}
