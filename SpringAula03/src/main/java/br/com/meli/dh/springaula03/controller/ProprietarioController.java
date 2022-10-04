package br.com.meli.dh.springaula03.controller;

import br.com.meli.dh.springaula03.model.Proprietario;
import br.com.meli.dh.springaula03.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
    @Autowired
    ProprietarioService service;

    @GetMapping
    public ResponseEntity<List<Proprietario>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
