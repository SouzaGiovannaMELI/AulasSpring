package br.com.meli.dh.springaula03.service;

import br.com.meli.dh.springaula03.exception.VeiculoNotFoundException;
import br.com.meli.dh.springaula03.model.Veiculo;
import br.com.meli.dh.springaula03.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService implements IVeiculo{
    @Autowired
    private VeiculoRepo repo;

    @Override
    public Veiculo getVeiculo(String placa) throws VeiculoNotFoundException {
        Optional<Veiculo> veiculo = repo.getVeiculo(placa);

        if(veiculo.isEmpty())
            throw new VeiculoNotFoundException("Veiculo não encontrado");
        return veiculo.get();
    }

    @Override
    public List<Veiculo> getAllVeiculos() {
        return null;
    }
}
