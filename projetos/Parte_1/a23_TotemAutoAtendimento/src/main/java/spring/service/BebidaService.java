package spring.service;

import dto.BebidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.BebidaModel;
import spring.repository.BebidaRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BebidaService {

    @Autowired
    BebidaRepository bebidaRepository;


    public List<BebidaModel> exibirBebidas() {
        return bebidaRepository.findAll();
    }

//    public List<BebidaDTO> exibirBebidas() {
//        List<BebidaModel> bebidas = bebidaRepository.findAll();
//
//        return bebidas.stream().map(bebida -> {
//                    BebidaDTO dto = new BebidaDTO();
//                    dto.setId(bebida.getId());
//                    dto.setNome(bebida.getNome());
//                    dto.setPreco(bebida.getPreco());
//                    return dto;
//
//                })
//                .collect(Collectors.toList());
//    }
}
