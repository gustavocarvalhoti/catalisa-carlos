package spring.service;
//Serviços que será responsável pela manipulação com o banco de dados e realizar as operações de negócios.


import dto.LancheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.LancheModel;
import spring.repository.LancheRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LancheService {

    @Autowired
    LancheRepository lancheRepository;

    public List<LancheModel> exibirLanches() {
        return lancheRepository.findAll();
    }



}
