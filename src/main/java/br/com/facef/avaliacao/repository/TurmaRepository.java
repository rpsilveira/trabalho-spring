package br.com.facef.avaliacao.repository;

import br.com.facef.avaliacao.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    @Query(value = "select *" +
            "from tb_turma t " +
            "join tb_aluno_turmas at " +
            "on t.id_turma = at.id_turma " +
            "join tb_aluno a " +
            "on at.id_aluno = a.id_aluno " +
            "where a.nome like %?1%", nativeQuery = true)
    public List<Turma> findByAluno(String nome);
}
