package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Professor;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfessorBusiness {
    List<Professor> findAll(Pageable pageable);
    Professor findById(int id);
    Professor save(Professor professor);
    void deleteById(int id);
}
