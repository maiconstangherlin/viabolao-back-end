package br.com.maicon.cursospring.controller;

import br.com.maicon.cursospring.model.Jogo;
import br.com.maicon.cursospring.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("jogo")
@CrossOrigin()
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping(value = "/")
    public List<Jogo> all() {
        return service.getAll();
    }

    @GetMapping(value = "/jogosrestantes")
    public int jogosrestantes() {
        return service.getJogosRestantes();
    }

    @PostMapping("/")
    public Long post(@RequestBody Jogo jogo) {
        return service.save(jogo);
    }

    @PutMapping("/")
    public boolean postList(@RequestBody List<Jogo> jogos) {
        return service.saveMany(jogos);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

}
