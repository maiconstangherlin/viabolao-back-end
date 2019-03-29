package br.com.maicon.cursospring.service;

import br.com.maicon.cursospring.model.Jogo;
import br.com.maicon.cursospring.model.Lance;
import br.com.maicon.cursospring.model.LanceDetail;
import br.com.maicon.cursospring.model.LancePaginado;
import br.com.maicon.cursospring.repository.JogoRepository;
import br.com.maicon.cursospring.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    @Autowired
    private JogoRepository jogoRepository;


    public List<Lance> getAll() {
        return lanceRepository.findAll();
    }

    public LancePaginado getByJogador(String jogador, int pagina) {
        List<Lance> lancesAux = new ArrayList<>();
        Lance lance;

        Pageable pageWithFiveElements = PageRequest.of(pagina, 5);
        Page<Jogo> jogos = jogoRepository.findAllByOrderByData(pageWithFiveElements);
        List<Lance> lances = lanceRepository.findAllByJogador(jogador);

        for (Jogo jogo : jogos.getContent()) {
            lance = lances.stream().filter(l -> l.getJogo().getId().equals(jogo.getId())).findFirst().orElse(null);

            if (lance == null) {
                lancesAux.add(new Lance(jogo));
            } else {
                lancesAux.add(lance);
            }
        }

        return new LancePaginado(lancesAux, jogos.getTotalElements());
    }

    public Lance save(Lance lance) {
        lance.setLanceDetail(new LanceDetail(new Date()));
        Lance lanceSave = lanceRepository.save(lance);

        return lanceSave;
    }

    public Lance save(Long id, Lance lanceAux) throws Exception {
        Lance lance = lanceRepository.findById(id).orElse(null);

        if (lance != null) {
            lance.setGolsA(lanceAux.getGolsA());
            lance.setGolsB(lanceAux.getGolsB());
            lance.setJogador(lanceAux.getJogador());
            lance.setLanceDetail(new LanceDetail(new Date()));

            Lance lanceSave = lanceRepository.save(lance);

            return lanceSave;
        } else {
            throw new Exception("ID não encontrado");
        }
    }


}
