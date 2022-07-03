package br.com.dsena7.lokomotimefc.service;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public interface JogadorService {

    List<JogadorDTO> getAllJogadores();

    JogadorDTO insertJogador(JogadorDTO jogadorDTO) throws BusinessException;
    
    Map<String, Object> atualizaJogador(Map<String, Object> mapBody) throws BusinessException, ParseException;

    void excluirJogador(Integer idJogador) throws BusinessException;
}
