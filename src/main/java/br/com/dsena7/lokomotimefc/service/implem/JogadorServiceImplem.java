package br.com.dsena7.lokomotimefc.service.implem;

import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import br.com.dsena7.lokomotimefc.model.mapper.JogadorMapper;
import br.com.dsena7.lokomotimefc.repository.JogadorRepository;
import br.com.dsena7.lokomotimefc.service.JogadorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JogadorServiceImplem implements JogadorService {

    @Autowired
    JogadorRepository repository;

    @Autowired
    JogadorMapper mapper;

    @Override
    public List<JogadorDTO> getAllJogadores() {
        log.info("Método getAllJogadores inicializado...");
        List<Jogador> entity = repository.findAll();

        if(entity.isEmpty()){
            log.info("Lista de jogadores está vazia");
        }
            List<JogadorDTO> dto = mapper.toDtoList(entity);

            log.info("Quantidade de jogadores na base...{}", entity.size());

        return dto;
    }

    @Override
    public JogadorDTO insertJogador(JogadorDTO jogadorDTO) {
        log.info("Método insertJogador inicializado...");
        Jogador jogador = repository.save(mapper.dtoToEntity(jogadorDTO));
        return mapper.entityToDto(jogador);
    }
}
