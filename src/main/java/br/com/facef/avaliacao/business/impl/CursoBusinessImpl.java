package br.com.facef.avaliacao.business.impl;

import br.com.facef.avaliacao.business.CursoBusiness;
import br.com.facef.avaliacao.model.Curso;
import br.com.facef.avaliacao.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoBusinessImpl implements CursoBusiness {

    private CursoRepository repository;

    @Autowired
    public CursoBusinessImpl(CursoRepository cursoRepository) {
        this.repository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return repository.findAll();
    }

    @Override
    public Curso findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
