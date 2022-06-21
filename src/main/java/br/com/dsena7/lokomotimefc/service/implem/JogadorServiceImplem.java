package br.com.dsena7.lokomotimefc.service.implem;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
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

            log.info("Quantidade de jogadores na base = {}", entity.size());

        return dto;
    }

	@Override
    public JogadorDTO insertJogador(JogadorDTO jogadorDTO) throws BusinessException {
        log.info("Método insertJogador inicializado...");
        
        if(repository.findById(jogadorDTO.getId()) != null && repository.findById(jogadorDTO.getId()).isPresent()) {
        	throw new BusinessException("Jogador já cadastrado na base");
        }
        
        Jogador jogador = repository.save(mapper.dtoToEntity(jogadorDTO));
        
        
        log.info("Jogador {}, número {} foi inserido na base", jogadorDTO.getNome(), jogadorDTO.getNumero());
        return mapper.entityToDto(jogador);
    }
}
