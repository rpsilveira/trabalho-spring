package br.com.facef.avaliacao.business.impl;

import br.com.facef.avaliacao.business.ProfessorBusiness;
import br.com.facef.avaliacao.model.Professor;
import br.com.facef.avaliacao.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorBusinessImpl implements ProfessorBusiness {

    private ProfessorRepository repository;

    @Autowired
    public ProfessorBusinessImpl(ProfessorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Professor> findAll(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public Professor findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Professor save(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
