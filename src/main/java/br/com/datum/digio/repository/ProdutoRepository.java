package br.com.datum.digio.repository;

import br.com.datum.digio.domain.Produto;
import br.com.datum.digio.dto.ProdutoDto;
import br.com.datum.digio.dto.RelatorioCompraDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT new br.com.datum.digio.dto.ProdutoDto(prod.codigo, prod.tipoVinho, " +
            "prod.preco, prod.safra, prod.anoCompra) " +
            "FROM Compra comp " +
            "JOIN comp.id.cliente cli " +
            "JOIN comp.id.produto prod " +
            "WHERE prod.tipoVinho = :tipo " +
            "AND cli.nome LIKE %:nome%")
    List<ProdutoDto> getRecomendacao(@Param("tipo") String tipo, @Param("nome") String nome);

}
