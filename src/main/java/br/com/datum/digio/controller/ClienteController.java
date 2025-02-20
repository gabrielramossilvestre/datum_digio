package br.com.datum.digio.controller;

import br.com.datum.digio.domain.Cliente;
import br.com.datum.digio.domain.Produto;
import br.com.datum.digio.dto.ProdutoDto;
import br.com.datum.digio.dto.RelatorioCompraDto;
import br.com.datum.digio.dto.TopClienteDto;
import br.com.datum.digio.repository.ClienteRepository;
import br.com.datum.digio.repository.CompraRepository;
import br.com.datum.digio.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class ClienteController {

    //Repository no controller só para não replicar tudo
    private final CompraRepository compraRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public ClienteController(CompraRepository compraRepository,
                             ClienteRepository clienteRepository,
                             ProdutoRepository produtoRepository) {
        this.compraRepository = compraRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/compras")
    public ResponseEntity<List<RelatorioCompraDto>> getCompras() {
        return ResponseEntity.ok(compraRepository.getRelatorioCompra());
    }

    @GetMapping("/maior-compra/{ano}")
    public ResponseEntity<List<RelatorioCompraDto>> getMaiorCompra(@PathVariable Integer ano) {
        return ResponseEntity.ok(compraRepository.getMaiorCompra(ano));
    }

    @GetMapping("/clientes-fieis")
    public ResponseEntity<List<TopClienteDto>> getTop() {
        return ResponseEntity.ok(clienteRepository.getTopClientes());
    }

    @GetMapping("/recomendacao/{cliente}/{tipo}")
    public ResponseEntity<ProdutoDto> getRecomendacao(@PathVariable String cliente
            , @PathVariable String tipo) {
        List<ProdutoDto> lst = produtoRepository.getRecomendacao(tipo, cliente);
        Random rand = new Random();
        int index = rand.nextInt(lst.size());
        return ResponseEntity.ok(lst.get(index));
    }

}
