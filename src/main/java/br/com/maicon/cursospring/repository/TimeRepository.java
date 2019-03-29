package br.com.maicon.cursospring.repository;

import br.com.maicon.cursospring.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
