package br.com.dsena7.lokomotimefc.model.mapper;

import br.com.dsena7.lokomotimefc.model.dto.JogadorDTO;
import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface JogadorMapper {

    List<JogadorDTO> toDtoList(List<Jogador> jogador);

    Jogador dtoToEntity(JogadorDTO dto);

    JogadorDTO entityToDto (Jogador jogador);
}
