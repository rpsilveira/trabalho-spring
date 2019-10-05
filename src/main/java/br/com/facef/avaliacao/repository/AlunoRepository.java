package br.com.facef.avaliacao.repository;

import br.com.facef.avaliacao.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
