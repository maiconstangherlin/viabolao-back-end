package br.com.maicon.cursospring.controller;

import br.com.maicon.cursospring.model.Time;
import br.com.maicon.cursospring.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("time")
@CrossOrigin()
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping(value = "/")
    public List<Time> allTimes() {
        return service.getAll();
    }

    @PostMapping("/")
    public Long post(@RequestBody Time time) {
        return service.save(time);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

}
