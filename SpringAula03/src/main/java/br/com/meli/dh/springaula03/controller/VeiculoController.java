package br.com.meli.dh.springaula03.controller;

import br.com.meli.dh.springaula03.dto.VeiculoDTO;
import br.com.meli.dh.springaula03.model.Veiculo;
import br.com.meli.dh.springaula03.service.IVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {
    // Injeção de dependencias (o framework que irá gerar esse objeto
    @Autowired
    private IVeiculo veiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa){
        Veiculo veiculo = veiculoService.getVeiculo(placa);

        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> getAll(){
        List<VeiculoDTO> veiculos = veiculoService.getAllVeiculos();

        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/byvalue")
    public ResponseEntity<List<Veiculo>> getAllOrderByValue(){
        List<Veiculo> veiculos = veiculoService.getAllOrderByValue();

        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Veiculo>> getAllOrderByModelo(@PathVariable String model){
        return new ResponseEntity<>(veiculoService.getOrderByModel(model), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVeiculo(@RequestBody Veiculo veiculo){
        veiculoService.save(veiculo);
    }
}
