package api.GestaoEscolar.repository;

import api.GestaoEscolar.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

}
