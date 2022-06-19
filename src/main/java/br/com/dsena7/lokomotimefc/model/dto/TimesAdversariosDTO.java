package br.com.dsena7.lokomotimefc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimesAdversariosDTO {

    private Integer idTime;

    private String nomeResponsavel;

    private String telefoneResponsavel;

    private String nomeDoTime;
}
