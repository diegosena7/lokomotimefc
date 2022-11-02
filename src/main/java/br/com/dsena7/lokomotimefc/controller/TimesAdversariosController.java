package br.com.dsena7.lokomotimefc.controller;


import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosDTO;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosResponseDTO;
import br.com.dsena7.lokomotimefc.service.implem.TimesAdversariosServiceImplem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/adversario")
public class TimesAdversariosController {

    @Autowired
    TimesAdversariosServiceImplem serviceImplem;

    @GetMapping
    public ResponseEntity<List<TimesAdversariosResponseDTO>> buscaListaJogadores(){
        return ResponseEntity.ok().body(serviceImplem.getAllTimesAdversarios());
    }

    @PostMapping
    public ResponseEntity<TimesAdversariosDTO> criaAdversario(@RequestBody TimesAdversariosDTO timesAdversariosDTO) throws BusinessException {
        return ResponseEntity.ok().body(serviceImplem.insertAdversario(timesAdversariosDTO));
    }

    @PatchMapping
    public ResponseEntity<Map<String, Object>> atualizarAdversario(@RequestBody Map<String, Object> bodyRequest) throws BusinessException, ParseException {
        return ResponseEntity.ok().body(serviceImplem.atualizaDadosAdversrio(bodyRequest));
    }
}
