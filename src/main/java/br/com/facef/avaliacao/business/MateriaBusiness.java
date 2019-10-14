package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Materia;

import java.util.List;

public interface MateriaBusiness {
    List<Materia> findAll();
    Materia findById(int id);
    Materia save(Materia materia);
    void deleteById(int id);
}
