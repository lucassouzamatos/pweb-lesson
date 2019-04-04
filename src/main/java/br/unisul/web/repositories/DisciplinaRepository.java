package br.unisul.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unisul.web.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{

}
