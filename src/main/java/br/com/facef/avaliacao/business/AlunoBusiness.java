package br.com.facef.avaliacao.business;

import br.com.facef.avaliacao.model.Aluno;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlunoBusiness {
    List<Aluno> findAll(Pageable pageable);
    Aluno findById(int id);
    Aluno save(Aluno aluno);
    void deleteById(int id);
}
