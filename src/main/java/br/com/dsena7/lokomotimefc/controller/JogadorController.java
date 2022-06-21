package br.com.dsena7.lokomotimefc.controller;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.service.implem.JogadorServiceImplem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    JogadorServiceImplem serviceImplem;

    @GetMapping
    public ResponseEntity<List<JogadorDTO>> buscaListaJogadores(){
        return ResponseEntity.ok().body(serviceImplem.getAllJogadores());
    }

    @PostMapping
    public ResponseEntity<JogadorDTO> inserirJogador(@RequestBody JogadorDTO requestJogador) throws BusinessException{
        return ResponseEntity.ok().body(serviceImplem.insertJogador(requestJogador));
    }
}
