package br.com.maicon.cursospring.model;

import lombok.Getter;

import java.util.List;

@Getter
public class LancePaginado {

    private List<Lance> lances;

    private long totalRegistros;

    public LancePaginado(List<Lance> lances, long totalRegistros) {
        this.lances = lances;
        this.totalRegistros = totalRegistros;
    }
}
