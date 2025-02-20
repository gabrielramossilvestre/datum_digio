package br.com.datum.digio.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    private Long codigo;

    @Column(name = "tipo_vinho")
    private String tipoVinho;

    private double preco;

    private String safra;

    @Column(name = "ano_compra")
    private int anoCompra;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
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

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", tipoVinho='" + tipoVinho + '\'' +
                ", preco=" + preco +
                ", safra='" + safra + '\'' +
                ", anoCompra=" + anoCompra +
                '}';
    }
}
