package br.com.meli.dh.springaula03.service;

import br.com.meli.dh.springaula03.model.Proprietario;
import br.com.meli.dh.springaula03.model.Veiculo;
import br.com.meli.dh.springaula03.repository.ProprietarioRepo;
import br.com.meli.dh.springaula03.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProprietarioService implements IProprietario{
    @Autowired
    ProprietarioRepo proprietarioRepo;
    @Autowired
    VeiculoRepo veiculoRepo;

    @Override
    public List<Proprietario> getAll() {
        List<Veiculo> veiculos = new ArrayList<>(veiculoRepo.getAll());
        List<Proprietario> proprietarios = new ArrayList<>(proprietarioRepo.getAll());

        proprietarios.stream()
                .forEach(proprietario -> {
                    for (int i = 0; i < veiculos.size(); i++) {
                        if(veiculos.get(i).getId_proprietario() == proprietario.getId()){
                            proprietario.addVeiculo(veiculos.remove(i));
                            veiculos.stream().forEach(System.out::println);
                            i--;
                        }
                    }
                });

        return proprietarios;
    }
}
