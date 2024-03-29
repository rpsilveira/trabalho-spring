package br.com.facef.avaliacao.business.impl;

import br.com.facef.avaliacao.business.TurmaBusiness;
import br.com.facef.avaliacao.model.Turma;
import br.com.facef.avaliacao.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaBusinessImpl implements TurmaBusiness {

    private TurmaRepository repository;

    @Autowired
    public TurmaBusinessImpl(TurmaRepository turmaRepository) {
        this.repository = turmaRepository;
    }

    @Override
    public List<Turma> findAll(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public Turma findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Turma save(Turma turma) {
        return repository.save(turma);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Turma> findByAluno(String nome) {
        return repository.findByAluno(nome);
    }

}
