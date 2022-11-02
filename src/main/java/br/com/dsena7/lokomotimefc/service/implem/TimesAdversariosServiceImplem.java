package br.com.dsena7.lokomotimefc.service.implem;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosDTO;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosResponseDTO;
import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import br.com.dsena7.lokomotimefc.model.entity.TimesAdversarios;
import br.com.dsena7.lokomotimefc.model.mapper.JogadorMapper;
import br.com.dsena7.lokomotimefc.model.mapper.TimesAdversariosMapper;
import br.com.dsena7.lokomotimefc.repository.JogadorRepository;
import br.com.dsena7.lokomotimefc.repository.TimesAdversariosRepository;
import br.com.dsena7.lokomotimefc.service.JogadorService;
import br.com.dsena7.lokomotimefc.service.TimesAdversariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class TimesAdversariosServiceImplem implements TimesAdversariosService {

	@Autowired
	TimesAdversariosRepository repository;

	@Autowired
	TimesAdversariosMapper mapper;

	@Override
	public List<TimesAdversariosResponseDTO> getAllTimesAdversarios() {
		log.info("Método getAllJogadores inicializado...");
		List<TimesAdversarios> entity = repository.findAll();

		if (entity.isEmpty()) {
			log.info("Lista de jogadores está vazia");
		}
		List<TimesAdversariosResponseDTO> dto = mapper.toDtoList(entity);

		log.info("Quantidade de jogadores na base = {}", entity.size());

		log.info("Método getAllJogadores finalizado...");
		Collections.sort(dto);
		return dto;
	}

	@Override
	public TimesAdversariosDTO insertAdversario(TimesAdversariosDTO adversarioDTO) throws BusinessException {
		log.info("Método insertAdversario inicializado...");

//		if (repository.findById(adversarioDTO.getNomeDoTime().isEmpty()) {
//			throw new BusinessException("Jogador já cadastrado na base");
//		}

		TimesAdversarios timesAdversarios = repository.save(mapper.dtoToEntity(adversarioDTO));

		log.info("Time {} foi inserido na base", adversarioDTO.getNomeDoTime());
		log.info("Método insertAdversario finalizado...");
		return mapper.entityToDto(timesAdversarios);
	}

	@Override
	public Map<String, Object> atualizaDadosAdversrio(Map<String, Object> mapBody) throws BusinessException, ParseException {

		log.info("Método atualizaDadosAdversrio inicializado...");

		Object idAdversario = mapBody.get("idTime");
		if (idAdversario == null || !(idAdversario instanceof Number)) {
			throw new BusinessException("Informe o id do Adversário para atualizar.");
		}

		Optional<TimesAdversarios> adversarioRequestById = repository.findById(Integer.valueOf(mapBody.get("idTime").toString()));
		
		if(adversarioRequestById.isEmpty()) {
			throw new BusinessException("Adversário não localizado na base para ser atualizado");
		}
		
		TimesAdversarios adversarioUpdated = insertMapInEntity(adversarioRequestById, mapBody);
		repository.save(adversarioUpdated);

		log.info("Método atualizaDadosAdversrio finalizado...");
		return mapBody;
	}

	@Override
	public void excluirAdverario(Integer idJogador) throws BusinessException {
		log.info("Método excluirAdverario inicializado...");
		if(repository.findById(idJogador).isEmpty()){
			throw new BusinessException("Jogador não localizado, verifique o id informado.");
		}
		repository.deleteById(idJogador);
		log.info("Método excluirAdverario finalizado...");
	}


	private TimesAdversarios insertMapInEntity(Optional<TimesAdversarios> adversarioRequestById, Map<String, Object> mapBody) throws BusinessException, ParseException {
		
		Object nomeDoTime = mapBody.get("nomeDoTime");
		if(nomeDoTime != null) {
			adversarioRequestById.get().setNomeDoTime(nomeDoTime.toString());
		}
		
		Object nomeResponsavel = mapBody.get("nomeResponsavel");
		if(nomeResponsavel != null) {
			adversarioRequestById.get().setNomeResponsavel(nomeResponsavel.toString());
		}
		
		Object telefoneResponsavel = mapBody.get("telefoneResponsavel");
		if(telefoneResponsavel != null) {
			adversarioRequestById.get().setTelefoneResponsavel(telefoneResponsavel.toString());
		}
		return adversarioRequestById.get();
	}
}
