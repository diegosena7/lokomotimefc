package br.com.dsena7.lokomotimefc.repository;

import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
