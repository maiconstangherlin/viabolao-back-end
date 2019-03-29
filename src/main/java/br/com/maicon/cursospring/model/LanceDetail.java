package br.com.maicon.cursospring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lances_details")
@Data
public class LanceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "ultima_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacao;

    public LanceDetail() {
    }

    public LanceDetail(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
