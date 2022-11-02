package br.com.dsena7.lokomotimefc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimesAdversariosResponseDTO implements Comparable<TimesAdversariosResponseDTO>{

    private Integer idTime;

    private String nomeResponsavel;

    private String telefoneResponsavel;

    private String nomeDoTime;

    @Override
    public int compareTo(TimesAdversariosResponseDTO adversariosDTO) {
        return this.nomeDoTime.compareTo(adversariosDTO.nomeDoTime);
    }
}
