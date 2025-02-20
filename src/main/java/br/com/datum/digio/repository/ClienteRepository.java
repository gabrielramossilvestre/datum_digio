package br.com.datum.digio.repository;

import br.com.datum.digio.domain.Cliente;
import br.com.datum.digio.dto.TopClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT new br.com.datum.digio.dto.TopClienteDto(" +
            "cli.nome, cli.cpf, " +
            "SUM(prod.preco * comp.quantidade), " +
            "COUNT(comp)) " +
            "FROM Compra comp " +
            "JOIN comp.id.cliente cli " +
            "JOIN comp.id.produto prod " +
            "GROUP BY cli.nome, cli.cpf " +
            "ORDER BY SUM(prod.preco * comp.quantidade) DESC " +
            "LIMIT 3")
    List<TopClienteDto> getTopClientes();

}
