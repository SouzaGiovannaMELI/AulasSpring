package br.com.meli.dh.springaula03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements Comparable<Veiculo>{
    private String placa;
    private String modelo;
    private int ano;
    private double valor;

    @Override
    public int compareTo(Veiculo other) {
        return Double.compare(this.getValor(), other.getValor());
    }
}
