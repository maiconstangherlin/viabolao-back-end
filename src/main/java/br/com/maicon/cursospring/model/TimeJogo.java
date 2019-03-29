package br.com.maicon.cursospring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "times")
@Data
public class TimeJogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @JsonManagedReference("jogos")
    @OneToMany(mappedBy = "time_a", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<JogoTimeA> jogos = new HashSet<>();
}
