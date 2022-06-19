package br.com.dsena7.lokomotimefc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idJogador;

    @Column(name="nome")
    private String nomeJogador;

    @Column(name="numero")
    private Integer numeroJogador;

    @Column(name="telefone")
    private String telefoneJogador;

    @Column(name="posicao")
    private String posicaoJogador;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="data_nascimento")
    private LocalDate dataNascimento;
}
