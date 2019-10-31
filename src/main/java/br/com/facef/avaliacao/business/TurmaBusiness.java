package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Turma;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TurmaBusiness {
    List<Turma> findAll(Pageable pageable);
    Turma findById(int id);
    Turma save(Turma turma);
    void deleteById(int id);
    List<Turma> findByAluno(String nome);
}
