package br.com.datum.digio.dto;

public class RelatorioCompraDto {
    private String nome;
    private String cpf;
    private int anoCompra;
    private double preco;
    private String safra;
    private String tipoVinho;
    private int quantidadeCompra;
    private double totalItens;

    public RelatorioCompraDto(String nome, String cpf, int anoCompra, double preco, String safra, String tipoVinho, int quantidadeCompra, double totalItens) {
        this.nome = nome;
        this.cpf = cpf;
        this.anoCompra = anoCompra;
        this.preco = preco;
        this.safra = safra;
        this.tipoVinho = tipoVinho;
        this.quantidadeCompra = quantidadeCompra;
        this.totalItens = totalItens;
    }

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

    public int getAnoCompra() {
        return anoCompra;
    }

    public void setAnoCompra(int anoCompra) {
        this.anoCompra = anoCompra;
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

    public String getTipoVinho() {
        return tipoVinho;
    }

    public void setTipoVinho(String tipoVinho) {
        this.tipoVinho = tipoVinho;
    }

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public double getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(double totalItens) {
        this.totalItens = totalItens;
    }
}
