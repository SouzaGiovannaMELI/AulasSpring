package br.com.meli.dh.springaula02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Ele gera gettes para todos os atributos
@Setter // Ele gera setter para todos os atributos
@AllArgsConstructor // Ele gera um construtor com todos os atributos
@NoArgsConstructor // Ele gera um construtor sem nenhum atributo
public class Produto {
    private int id;
    private String nome;
    private double valor;
}
