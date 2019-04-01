package br.com.maicon.cursospring.service;

import br.com.maicon.cursospring.model.Classificacao;
import br.com.maicon.cursospring.model.JogadorPonto;
import br.com.maicon.cursospring.model.Lance;
import br.com.maicon.cursospring.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassificacaoService {

    @Autowired
    private LanceRepository lanceRepository;

    private Map<String, Integer> mapRanking;
    private Map<String, Integer> mapLideres;

    public Classificacao retAll() {
        List<Lance> lances = lanceRepository.findAll();

        return classificador(lances);
    }

    private Classificacao classificador(List<Lance> lances) {
        this.mapRanking = new HashMap<>();
        this.mapLideres = new HashMap<>();

        Integer pontos;

        for (Lance lance : lances) {
            pontos = 0;

            if (placarIgual(lance.getGolsA(), lance.getJogo().getGolsA())) {
                pontos += 3;
            }

            if (placarIgual(lance.getGolsB(), lance.getJogo().getGolsB())) {
                pontos += 3;
            }

            if (pontos.equals(6)) {
                pontos += 2;
            }

            if (mapRanking.containsKey(lance.getJogador())) {

                pontos += mapRanking.get(lance.getJogador());
                mapRanking.replace(lance.getJogador(), pontos);

            } else {
                mapRanking.put(lance.getJogador(), pontos);
            }
        }

        this.mapLideres = calculaLideres();

        return new Classificacao(this.getRanking(), this.getLideres());
    }

    private Map<String, Integer> calculaLideres() {
        if (mapRanking == null)
            return null;

        Map<String, Integer> top3 =
                mapRanking.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return top3;
    }

    private List<JogadorPonto> getLideres() {
        if (mapLideres == null)
            return null;

        return mapLideres.entrySet()
                .stream()
                .map(e -> new JogadorPonto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private List<JogadorPonto> getRanking() {
        if (mapRanking == null)
            return null;

        return mapRanking.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(e -> new JogadorPonto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private boolean placarIgual(Integer golsLance, Integer golsJogo) {
        if (golsLance != null && golsJogo != null) {
            return golsLance.equals(golsJogo);
        }

        return false;
    }

}
