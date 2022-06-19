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
public class JogadorDTO {

    private Integer id;

    private String nome;

    private Integer numero;

    private String telefone;

    private String posicao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @JsonFormat(pattern = "dd/MM/aaaa")
    private LocalDate data_nascimento;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public Integer getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getPosicao() {
//        return posicao;
//    }
//
//    public void setPosicao(String posicao) {
//        this.posicao = posicao;
//    }
//
//    public LocalDate getData_nascimento() {
//        return data_nascimento;
//    }
//
//    public void setData_nascimento(LocalDate data_nascimento) {
//        this.data_nascimento = data_nascimento;
//    }
}
