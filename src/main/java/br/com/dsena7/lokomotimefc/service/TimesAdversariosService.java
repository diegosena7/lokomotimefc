package br.com.dsena7.lokomotimefc.service;

import br.com.dsena7.lokomotimefc.exceptions.BusinessException;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosDTO;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosResponseDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public interface TimesAdversariosService {

    List<TimesAdversariosResponseDTO> getAllTimesAdversarios();

    TimesAdversariosDTO insertAdversario(TimesAdversariosDTO adversarioDTO) throws BusinessException;
    
    Map<String, Object> atualizaDadosAdversrio(Map<String, Object> mapBody) throws BusinessException, ParseException;

    void excluirAdverario(Integer idAdversario) throws BusinessException;
}
