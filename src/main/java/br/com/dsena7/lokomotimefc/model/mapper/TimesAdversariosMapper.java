package br.com.dsena7.lokomotimefc.model.mapper;

import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosDTO;
import br.com.dsena7.lokomotimefc.model.dto.TimesAdversariosResponseDTO;
import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import br.com.dsena7.lokomotimefc.model.entity.TimesAdversarios;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TimesAdversariosMapper {

    List<TimesAdversariosResponseDTO> toDtoList(List<TimesAdversarios> adversarios);

    TimesAdversarios dtoToEntity(TimesAdversariosDTO dto);

    TimesAdversariosDTO entityToDto (TimesAdversarios jogador);
}
