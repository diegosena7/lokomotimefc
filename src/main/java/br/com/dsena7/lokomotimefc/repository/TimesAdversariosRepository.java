package br.com.dsena7.lokomotimefc.repository;

import br.com.dsena7.lokomotimefc.model.entity.Jogador;
import br.com.dsena7.lokomotimefc.model.entity.TimesAdversarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesAdversariosRepository extends JpaRepository<TimesAdversarios, Integer> {
	
}
