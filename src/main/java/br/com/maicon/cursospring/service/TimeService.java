package br.com.maicon.cursospring.service;

import br.com.maicon.cursospring.model.Jogo;
import br.com.maicon.cursospring.model.Time;
import br.com.maicon.cursospring.repository.JogoRepository;
import br.com.maicon.cursospring.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private JogoRepository jogoRepository;

    public List<Time> getAll() {
        return timeRepository.findAll();
    }

    public Long save(Time time) {
        Long id = timeRepository.save(time).getId();
        return id;
    }

    public boolean delete(Long id) throws Exception {
        Time time = timeRepository.findById(id).orElse(null);
        Jogo jogo = jogoRepository.findFirstByTimeAOrTimeB(time, time);

        if (jogo != null) {
            throw new Exception("Time não pode ser removido pois contém jogos.");
        } else {
            timeRepository.deleteById(id);
            return true;
        }
    }

}
