package br.com.dsena7.lokomotimefc.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO implements Comparable<JogadorDTO>{

    private Integer id;

    private String nome;

    private Integer numero;

    private String telefone;

    private String posicao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @JsonFormat(pattern = "dd/MM/aaaa")
    private LocalDate data_nascimento;

    @Override
    public int compareTo(JogadorDTO jogadorDTO) {
        return this.nome.compareTo(jogadorDTO.nome);
    }
}
