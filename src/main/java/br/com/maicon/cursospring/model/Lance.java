package br.com.maicon.cursospring.model;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name = "lances")
@Data
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jogador")
    private String jogador;

    @ManyToOne()
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @Column(name = "gols_a")
    private Integer golsA;

    @Column(name = "gols_b")
    private Integer golsB;

    @OneToOne(cascade = CascadeType.ALL)
    private LanceDetail lanceDetail;

    public Lance() {
    }

    public Lance(Jogo jogo) {
        this.jogo = jogo;
    }
}
