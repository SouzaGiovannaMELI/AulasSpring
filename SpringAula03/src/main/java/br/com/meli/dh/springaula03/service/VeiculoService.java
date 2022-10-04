package br.com.meli.dh.springaula03.service;

import br.com.meli.dh.springaula03.dto.VeiculoDTO;
import br.com.meli.dh.springaula03.exception.NotFoundException;
import br.com.meli.dh.springaula03.model.Veiculo;
import br.com.meli.dh.springaula03.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService implements IVeiculo{
    @Autowired
    private VeiculoRepo repo;

    @Override
    public Veiculo getVeiculo(String placa) throws NotFoundException {
        Optional<Veiculo> veiculo = repo.getVeiculo(placa);

        if(veiculo.isEmpty())
            throw new NotFoundException("Veiculo não encontrado");
        return veiculo.get();
    }

    @Override
    public List<VeiculoDTO> getAllVeiculos() {
        //return repo.getAll().stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
        return repo.getAll().stream().map(VeiculoDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<Veiculo> getAllOrderByValue() {
        List<Veiculo> veiculos = repo.getAll();

        return veiculos.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void save(Veiculo veiculo) {
        repo.saveVeiculo(veiculo);
    }

    @Override
    public List<Veiculo> getOrderByModel(String model) {
        return repo.getAll().stream()
                .filter(veiculo -> veiculo.getModelo().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }


}
