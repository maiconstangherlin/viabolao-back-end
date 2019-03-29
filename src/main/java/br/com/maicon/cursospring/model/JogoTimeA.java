package br.com.maicon.cursospring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "jogos")
@Data
public class JogoTimeA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @JsonBackReference("jogos")
    @ManyToOne()
    @JoinColumn(name = "time_a")
    private TimeJogo time_a;

    @Column(name = "gols_a")
    private Integer golsA;
}
