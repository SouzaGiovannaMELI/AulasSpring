package br.com.meli.dh.springaula03.service;

import br.com.meli.dh.springaula03.dto.VeiculoDTO;
import br.com.meli.dh.springaula03.exception.NotFoundException;
import br.com.meli.dh.springaula03.model.Veiculo;

import java.util.List;

public interface IVeiculo {
    Veiculo getVeiculo(String placa) throws NotFoundException;
    List<VeiculoDTO> getAllVeiculos();
    List<Veiculo> getAllOrderByValue();
    void save(Veiculo veiculo);
    List<Veiculo> getOrderByModel(String model);
}
