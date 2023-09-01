package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.LancheModel;

//Interface para para permitir a interação com o banco de dados
@Repository
public interface LancheRepository extends JpaRepository<LancheModel, Long> {

}
