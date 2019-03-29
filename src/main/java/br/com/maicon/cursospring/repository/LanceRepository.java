package br.com.maicon.cursospring.repository;

import br.com.maicon.cursospring.model.Lance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanceRepository extends JpaRepository<Lance, Long> {

    List<Lance> findAllByJogador(String jogador);
}
