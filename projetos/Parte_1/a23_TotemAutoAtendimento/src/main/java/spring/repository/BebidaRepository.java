package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.BebidaModel;
//Interface para para permitir a interação com o banco de dados

@Repository
public interface BebidaRepository extends JpaRepository<BebidaModel, Long> {
}
