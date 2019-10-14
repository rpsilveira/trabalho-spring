package br.com.facef.avaliacao.business.impl;

import br.com.facef.avaliacao.business.MateriaBusiness;
import br.com.facef.avaliacao.model.Materia;
import br.com.facef.avaliacao.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaBusinessImpl implements MateriaBusiness {

    private MateriaRepository repository;

    @Autowired
    public MateriaBusinessImpl(MateriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Materia> findAll() {
        return repository.findAll();
    }

    @Override
    public Materia findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Materia save(Materia materia) {
        return repository.save(materia);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
