package br.com.maicon.cursospring.model;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Classificacao {

    private List<Lance> lances;

    private Map<String, Integer> mapRanking;
    private Map<String, Integer> mapLideres;

    private List<JogadorPonto> ranking;
    private List<JogadorPonto> lideres;

    public Classificacao(List<Lance> lances) {
        this.lances = lances;
        this.mapRanking = new HashMap<>();
        this.mapLideres = new HashMap<>();
        this.ranking = new ArrayList<>();
        this.lideres = new ArrayList<>();
    }

    public List<JogadorPonto> getLideres() {
        if (mapLideres == null)
            return null;

        return mapLideres.entrySet()
                .stream()
                .map(e -> new JogadorPonto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public List<JogadorPonto> getRanking() {
        if (mapRanking == null)
            return null;

        return mapRanking.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(e -> new JogadorPonto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> calculaPontuacao() {
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

        return mapRanking;
    }

    public Map<String, Integer> calculaLideres() {
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

    private boolean placarIgual(Integer golsLance, Integer golsJogo){
        if (golsLance != null && golsJogo != null) {
            return golsLance.equals(golsJogo);
        }

        return false;
    }

    public class JogadorPonto implements Serializable {
        private String jogador;
        private Integer pontos;

        public JogadorPonto(String jogador, Integer pontos) {
            this.jogador = jogador;
            this.pontos = pontos;
        }

        public String getJogador() {
            return jogador;
        }

        public Integer getPontos() {
            return pontos;
        }
    }
}