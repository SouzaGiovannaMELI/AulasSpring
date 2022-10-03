package br.com.meli.dh.springaula03.repository;

import br.com.meli.dh.springaula03.model.Veiculo;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepo {
    private final String linkFile = "src/main/resources/veiculos.json";
    ObjectMapper mapper = new ObjectMapper();

    public Optional<Veiculo> getVeiculo(String placa){
        List<Veiculo> veiculos = getVeiculosArquivo();

        for(Veiculo veiculo : veiculos){
            if(veiculo.getPlaca().equals(placa))
                return Optional.of(veiculo);
        }

        return Optional.empty();
    }

    public List<Veiculo> getAll(){
        return getVeiculosArquivo();
    }

    public void saveVeiculo(Veiculo novoVeiculo){
        List<Veiculo> veiculos = new ArrayList<>(getVeiculosArquivo());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        veiculos.add(novoVeiculo);

        try{
            writer.writeValue(new File(linkFile), veiculos);
        } catch (Exception e) {
            System.out.println("Erro ao salvar os dados!");
        }
    }

    private List<Veiculo> getVeiculosArquivo(){
        List<Veiculo> veiculos = null;

        try{
            veiculos = Arrays.asList(mapper.readValue(new File(linkFile), Veiculo[].class));
        }catch (Exception ex){

        }

        return veiculos;
    }
}
