package br.com.maicon.cursospring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "jogos")
@Data
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time_a")
    private Time timeA;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time_b")
    private Time timeB;

    @Column(name = "gols_a")
    private Integer golsA;

    @Column(name = "gols_b")
    private Integer golsB;
}
