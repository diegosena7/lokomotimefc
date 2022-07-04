package br.com.dsena7.lokomotimefc.service.implem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import br.com.dsena7.lokomotimefc.model.mapper.JogadorMapper;
import br.com.dsena7.lokomotimefc.repository.JogadorRepository;
import br.com.dsena7.lokomotimefc.service.JogadorService;
import lombok.extern.slf4j.Slf4j;

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

		if (entity.isEmpty()) {
			log.info("Lista de jogadores está vazia");
		}
		List<JogadorDTO> dto = mapper.toDtoList(entity);

		log.info("Quantidade de jogadores na base = {}", entity.size());

		log.info("Método getAllJogadores finalizado...");
		return dto;
	}

	@Override
	public JogadorDTO insertJogador(JogadorDTO jogadorDTO) throws BusinessException {
		log.info("Método insertJogador inicializado...");

		if (repository.findById(jogadorDTO.getId()) != null && repository.findById(jogadorDTO.getId()).isPresent()) {
			throw new BusinessException("Jogador já cadastrado na base");
		}

		Jogador jogador = repository.save(mapper.dtoToEntity(jogadorDTO));

		log.info("Jogador {}, número {} foi inserido na base", jogadorDTO.getNome(), jogadorDTO.getNumero());
		log.info("Método insertJogador finalizado...");
		return mapper.entityToDto(jogador);
	}

	@Override
	public Map<String, Object> atualizaJogador(Map<String, Object> mapBody) throws BusinessException, ParseException {

		log.info("Método atualizaJogador inicializado...");

		Object idJogador = mapBody.get("id");
		if (idJogador == null || !(idJogador instanceof Number)) {
			throw new BusinessException("Informe o id do Jogador para atualizar.");
		}

		Optional<Jogador> jogadorRequestById = repository.findById(Integer.valueOf(mapBody.get("id").toString()));
		
		if(jogadorRequestById.isEmpty()) {
			throw new BusinessException("Jogador não localizado na base para ser atualizado");
		}
		
		Jogador jogadorUpdated = insertMapInEntity(jogadorRequestById, mapBody);
		repository.save(jogadorUpdated);

		log.info("Método atualizaJogador finalizado...");
		return mapBody;
	}

	@Override
	public void excluirJogador(Integer idJogador) throws BusinessException {
		log.info("Método excluirJogador inicializado...");
		if(repository.findById(idJogador).isEmpty()){
			throw new BusinessException("Jogador não localizado, verifique o id informado.");
		}
		repository.deleteById(idJogador);
		log.info("Método excluirJogador finalizado...");
	}


	private Jogador insertMapInEntity(Optional<Jogador> jogadorRequestById, Map<String, Object> mapBody) throws BusinessException, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Object nomeJogador = mapBody.get("nome");
		if(nomeJogador != null) {
			jogadorRequestById.get().setNome(nomeJogador.toString());
		}
		
		Object numeroJogador = mapBody.get("numero");
		if(numeroJogador != null) {
			jogadorRequestById.get().setNumero(Integer.valueOf(numeroJogador.toString()));
		}
		
		Object telefoneJogador = mapBody.get("telefone");
		if(telefoneJogador != null) {
			jogadorRequestById.get().setTelefone(telefoneJogador.toString());
		}
		
		Object posicaoJogador = mapBody.get("posicao");
		if(posicaoJogador != null) {
			jogadorRequestById.get().setPosicao(posicaoJogador.toString());
		}
		
		Object dtNascimento = mapBody.get("data_nascimento");
		if(posicaoJogador != null) {
			Date teste = sdf.parse(dtNascimento.toString());
			jogadorRequestById.get().setData_nascimento(teste);
		}
		return jogadorRequestById.get();
	}
}
