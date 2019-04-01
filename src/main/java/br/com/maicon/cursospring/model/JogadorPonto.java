package br.com.maicon.cursospring.model;

import lombok.Getter;

@Getter
public class JogadorPonto {
    private String jogador;
    private Integer pontos;

    public JogadorPonto(String jogador, Integer pontos) {
        this.jogador = jogador;
        this.pontos = pontos;
    }

}
