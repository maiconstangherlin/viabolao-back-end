package br.com.maicon.cursospring.service;

import br.com.maicon.cursospring.model.Classificacao;
import br.com.maicon.cursospring.model.Lance;
import br.com.maicon.cursospring.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassificacaoService {

    @Autowired
    private LanceRepository lanceRepository;

    public Classificacao retAll() {
        List<Lance> lances = lanceRepository.findAll();

        Classificacao classificacao = new Classificacao(lances);

        Map<String, Integer> stringIntegerMap = classificacao.calculaPontuacao();

        return classificacao;
    }

}
