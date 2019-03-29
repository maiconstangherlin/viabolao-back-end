package br.com.maicon.cursospring.controller;

import br.com.maicon.cursospring.model.TimeJogo;
import br.com.maicon.cursospring.repository.TimeJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController()
@RequestMapping("timejogo")
@CrossOrigin()
public class TimeJogoController {

    @Autowired
    private TimeJogoRepository repository;

    @GetMapping(value = "/")
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity(repository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<?> byId(@PathVariable("id") Long id) {
        TimeJogo time = repository.findById(id).orElse(null);
        time.getJogos().size();

        try {
            return new ResponseEntity(time, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

