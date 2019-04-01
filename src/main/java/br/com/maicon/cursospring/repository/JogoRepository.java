package br.com.maicon.cursospring.repository;

import br.com.maicon.cursospring.model.Jogo;
import br.com.maicon.cursospring.model.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findAllByOrderByData();

    Page<Jogo> findAllByOrderByData(Pageable pageable);

    Jogo findFirstByTimeAOrTimeB(Time timeA, Time timeB);

    int countAllByDataAfter(Date data);

    int countJogosByGolsAIsNullOrGolsBIsNull();

    @Override
    Page<Jogo> findAll(Pageable pageable);
}
