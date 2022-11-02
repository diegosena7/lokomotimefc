package br.com.dsena7.lokomotimefc.controller;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.model.dto.JogadorResponseDTO;
import br.com.dsena7.lokomotimefc.service.implem.JogadorServiceImplem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    JogadorServiceImplem serviceImplem;

    @GetMapping
    public ResponseEntity<List<JogadorResponseDTO>> buscaListaJogadores(){
        return ResponseEntity.ok().body(serviceImplem.getAllJogadores());
    }

    @PostMapping
    public ResponseEntity<JogadorDTO> inserirJogador(@RequestBody JogadorDTO requestJogador) throws BusinessException{
        return ResponseEntity.ok().body(serviceImplem.insertJogador(requestJogador));
    }
    
    @PatchMapping
    public ResponseEntity<Map<String, Object>> atualizarJogador(@RequestBody Map<String, Object> bodyRequest) throws BusinessException, ParseException{
    	 return ResponseEntity.ok().body(serviceImplem.atualizaJogador(bodyRequest));
    }

    @DeleteMapping(value = "/{idJogador}")
    public ResponseEntity<JogadorDTO> deleteAfiliado(@PathVariable("idJogador") Integer idJogador) throws BusinessException {
        serviceImplem.excluirJogador(idJogador);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
