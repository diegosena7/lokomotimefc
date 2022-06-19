package br.com.dsena7.lokomotimefc.service;

import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JogadorService {

    List<JogadorDTO> getAllJogadores();

    JogadorDTO insertJogador(JogadorDTO jogadorDTO);

}
