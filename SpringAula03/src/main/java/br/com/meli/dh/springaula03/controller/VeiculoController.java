package br.com.meli.dh.springaula03.controller;

import br.com.meli.dh.springaula03.exception.VeiculoNotFoundException;
import br.com.meli.dh.springaula03.model.Veiculo;
import br.com.meli.dh.springaula03.service.IVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {
    // Injeção de dependencias (o framework que irá gerar esse objeto
    @Autowired
    private IVeiculo veiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa){
        try{
            Veiculo veiculo = veiculoService.getVeiculo(placa);

            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        }catch (VeiculoNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
