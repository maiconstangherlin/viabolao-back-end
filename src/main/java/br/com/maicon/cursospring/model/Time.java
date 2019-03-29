package br.com.maicon.cursospring.model;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name = "times")
@Data
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "url_imagem")
    private String urlImagem;

}
