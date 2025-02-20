package br.com.datum.digio.dto;

import br.com.datum.digio.domain.Compra;
import br.com.datum.digio.domain.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompraDto {

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("codigo")
    private Long codigo;

    public Compra toEntity() {
        Compra compra = new Compra();
        compra.setQuantidade(quantidade);
        var prod = new Produto();
        prod.setCodigo(codigo);
        compra.getId().setProduto(prod);
        return compra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
