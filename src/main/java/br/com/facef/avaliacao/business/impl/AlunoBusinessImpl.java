package br.com.facef.avaliacao.business.impl;

import br.com.facef.avaliacao.business.AlunoBusiness;
import br.com.facef.avaliacao.model.Aluno;
import br.com.facef.avaliacao.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoBusinessImpl implements AlunoBusiness {

    private AlunoRepository repository;

    @Autowired
    public AlunoBusinessImpl(AlunoRepository alunoRepository) {
        this.repository = alunoRepository;
    }

    @Override
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    @Override
    public Aluno findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
