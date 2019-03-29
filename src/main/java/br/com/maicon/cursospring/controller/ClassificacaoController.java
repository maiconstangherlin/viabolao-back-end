package br.com.maicon.cursospring.controller;

import br.com.maicon.cursospring.model.Classificacao;
import br.com.maicon.cursospring.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("classificacao")
@CrossOrigin()
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService service;

    @GetMapping(value = "/")
    public Classificacao allTimes() {
        return service.retAll();
    }

}
