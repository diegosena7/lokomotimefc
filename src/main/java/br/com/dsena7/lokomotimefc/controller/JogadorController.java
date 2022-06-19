package br.com.dsena7.lokomotimefc.controller;

import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.service.implem.JogadorServiceImplem;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
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
    public ResponseEntity<JogadorDTO> inserirJogador(@RequestBody JogadorDTO requestJogador){
        return ResponseEntity.ok().body(serviceImplem.insertJogador(requestJogador));
    }
}
