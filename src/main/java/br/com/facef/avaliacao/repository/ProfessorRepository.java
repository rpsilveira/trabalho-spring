package br.com.facef.avaliacao.repository;

import br.com.facef.avaliacao.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
