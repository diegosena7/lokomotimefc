package br.com.dsena7.lokomotimefc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancasDTO {

    private Integer idFinanca;

    private LocalDate dataPagamento;

    private BigDecimal valorPagamento;
}
