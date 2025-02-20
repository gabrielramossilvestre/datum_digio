package br.com.datum.digio.dto;

import br.com.datum.digio.domain.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoDto {

    public ProdutoDto() {}

    public ProdutoDto(long codigo, String tipoVinho, double preco, String safra, int anoCompra) {
        this.codigo = codigo;
        this.tipoVinho = tipoVinho;
        this.preco = preco;
        this.safra = safra;
        this.anoCompra = anoCompra;
    }

    @JsonProperty("codigo")
    private long codigo;

    @JsonProperty("tipo_vinho")
    private String tipoVinho;

    @JsonProperty("preco")
    private double preco;

    @JsonProperty("safra")
    private String safra;

    @JsonProperty("ano_compra")
    private int anoCompra;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTipoVinho() {
        return tipoVinho;
    }

    public void setTipoVinho(String tipoVinho) {
        this.tipoVinho = tipoVinho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public int getAnoCompra() {
        return anoCompra;
    }

    public void setAnoCompra(int anoCompra) {
        this.anoCompra = anoCompra;
    }

    public Produto toEntity() {
        var prod = new Produto();
        prod.setCodigo(codigo);
        prod.setPreco(preco);
        prod.setTipoVinho(tipoVinho);
        prod.setSafra(safra);
        prod.setAnoCompra(anoCompra);
        return prod;
    }
}
