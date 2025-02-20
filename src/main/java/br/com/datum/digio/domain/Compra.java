package br.com.datum.digio.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "compras")
public class Compra {

    @EmbeddedId
    private CompraId id = new CompraId();

    @Column(nullable = false)
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CompraId getId() {
        return id;
    }

    public void setId(CompraId id) {
        this.id = id;
    }
}
