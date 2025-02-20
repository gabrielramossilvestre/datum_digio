package br.com.datum.digio.dto;

import br.com.datum.digio.domain.Cliente;
import br.com.datum.digio.domain.Compra;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("compras")
    private List<CompraDto> compras;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<CompraDto> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraDto> compras) {
        this.compras = compras;
    }

    public Cliente toEntity() {
        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setCpf(cpf);
        List<Compra> lst = new ArrayList<>();
        for (CompraDto comp : compras) {
            lst.add(comp.toEntity());
        }
        return cli;
    }
}
