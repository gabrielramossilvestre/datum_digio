package br.com.datum.digio.repository;

import br.com.datum.digio.domain.Compra;
import br.com.datum.digio.dto.RelatorioCompraDto;
import br.com.datum.digio.dto.TopClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {


    @Query("SELECT new br.com.datum.digio.dto.RelatorioCompraDto(" +
            "cli.nome, cli.cpf, " +
            "prod.anoCompra, prod.preco, prod.safra, prod.tipoVinho, " +
            "comp.quantidade, (prod.preco * comp.quantidade)) " +
            "FROM Compra comp " +
            "JOIN comp.id.cliente cli " +
            "JOIN comp.id.produto prod " +
            "ORDER by prod.preco")
    List<RelatorioCompraDto> getRelatorioCompra();

    @Query("SELECT new br.com.datum.digio.dto.RelatorioCompraDto(" +
            "cli.nome, cli.cpf, " +
            "prod.anoCompra, prod.preco, prod.safra, prod.tipoVinho, " +
            "comp.quantidade, (prod.preco * comp.quantidade)) " +
            "FROM Compra comp " +
            "JOIN comp.id.cliente cli " +
            "JOIN comp.id.produto prod " +
            "WHERE prod.anoCompra = :ano " +
            "AND (prod.preco * comp.quantidade) = " +
            "(SELECT MAX(produto.preco * compra.quantidade) " +
            "FROM Compra compra " +
            "JOIN compra.id.produto produto " +
            "WHERE produto.anoCompra = :ano) " +
            "ORDER by prod.preco")
    List<RelatorioCompraDto> getMaiorCompra(@Param("ano") int ano);

}
