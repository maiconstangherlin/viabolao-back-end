package br.com.maicon.cursospring.service;

import br.com.maicon.cursospring.model.Jogo;
import br.com.maicon.cursospring.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    public List<Jogo> getAll() {
        return repository.findAllByOrderByData();
    }

    public int getJogosRestantes() {
        return repository.countAllByDataAfter(new Date());
    }

    public boolean saveMany(List<Jogo> jogos) {
        repository.saveAll(jogos);
        return true;
    }

    public Long save(Jogo jogo) {
        Long id = repository.save(jogo).getId();
        return id;
    }

    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }


}
