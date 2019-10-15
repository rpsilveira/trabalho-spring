package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Professor;

import java.util.List;

public interface ProfessorBusiness {
    List<Professor> findAll();
    Professor findById(int id);
    Professor save(Professor professor);
    void deleteById(int id);
}
