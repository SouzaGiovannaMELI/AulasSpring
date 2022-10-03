package br.com.meli.dh.springaula03.service;

import br.com.meli.dh.springaula03.exception.VeiculoNotFoundException;
import br.com.meli.dh.springaula03.model.Veiculo;

import java.util.List;

public interface IVeiculo {
    Veiculo getVeiculo(String placa) throws VeiculoNotFoundException;
    List<Veiculo> getAllVeiculos();
}
