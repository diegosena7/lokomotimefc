package br.com.dsena7.lokomotimefc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="times_adversarios")
public class TimesAdversarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idTime;

    @Column(name="nome_responsavel")
    private String nomeResponsavel;

    @Column(name="telefone_responsavel")
    private String telefoneResponsavel;

    @Column(name="nome_do_time")
    private String nomeDoTime;
}
