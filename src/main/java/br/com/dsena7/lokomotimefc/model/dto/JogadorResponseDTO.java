package br.com.dsena7.lokomotimefc.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogadorResponseDTO implements Comparable<JogadorResponseDTO>{

    private Integer id;

    private String nome;

    private Integer numero;

    private String telefone;

    private String posicao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @JsonFormat(pattern = "dd/MM/aaaa")
    private LocalDate data_nascimento;

    @Override
    public int compareTo(JogadorResponseDTO jogadorDTO) {
        return this.nome.compareTo(jogadorDTO.nome);
    }
}
