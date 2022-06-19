package br.com.dsena7.lokomotimefc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="financas")
public class Financas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idFinanca;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="data_pagamento")
    private LocalDate dataPagamento;

    @Column(name="valor_pagamento")
    private BigDecimal valorPagamento;
}
