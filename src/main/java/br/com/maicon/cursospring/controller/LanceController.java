package br.com.maicon.cursospring.controller;

import br.com.maicon.cursospring.model.Lance;
import br.com.maicon.cursospring.model.LancePaginado;
import br.com.maicon.cursospring.service.LanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("lance")
@CrossOrigin()
public class LanceController {

    @Autowired
    private LanceService service;

    @GetMapping(value = "/")
    public List<Lance> all() {
        return service.getAll();
    }

    @GetMapping(value = "/jogador")
    public LancePaginado getByJogadorPagina(@RequestParam("jogador") String jogador, @RequestParam("pagina") int pagina) {
        return service.getByJogador(jogador, pagina);
    }

    @PostMapping("/")
    public Lance post(@RequestBody Lance lance) {
        return service.save(lance);
    }

    @PutMapping("/{id}")
    public Lance put(@PathVariable("id") Long id, @RequestBody Lance lance) throws Exception {
        return service.save(id, lance);
    }

}
