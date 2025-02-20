package br.com.datum.digio.dto;

public class TopClienteDto {

    private Long totalCompras;
    private String nome;
    private String cpf;
    private Double totalItens;

    public TopClienteDto(String nome, String cpf, Double totalItens, Long totalCompras) {
        this.totalCompras = totalCompras;
        this.nome = nome;
        this.cpf = cpf;
        this.totalItens = totalItens;
    }

    public Long getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(Long totalCompras) {
        this.totalCompras = totalCompras;
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

    public Double getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(Double totalItens) {
        this.totalItens = totalItens;
    }
}
