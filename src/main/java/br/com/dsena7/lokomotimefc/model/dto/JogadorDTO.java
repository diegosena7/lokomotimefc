package br.com.dsena7.lokomotimefc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO {

    private Integer idJogador;

    private String nomeJogador;

    private Integer numeroJogador;

    private String telefoneJogador;

    private String posicaoJogador;

    private LocalDate dataNascimento;
}
