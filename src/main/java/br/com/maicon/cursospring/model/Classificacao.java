package br.com.maicon.cursospring.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Classificacao {

    private List<JogadorPonto> ranking;
    private List<JogadorPonto> lideres;

    public Classificacao(List<JogadorPonto> ranking, List<JogadorPonto> lideres) {
        if (ranking == null) {
            this.ranking = new ArrayList<>();
        } else {
            this.ranking = ranking;
        }

        if (lideres == null) {
            this.lideres = new ArrayList<>();
        } else {
            this.lideres = lideres;
        }

    }
}