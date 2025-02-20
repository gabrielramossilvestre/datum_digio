package br.com.datum.digio.config;

import br.com.datum.digio.dto.ClienteDto;
import br.com.datum.digio.dto.CompraDto;
import br.com.datum.digio.dto.ProdutoDto;
import br.com.datum.digio.repository.ClienteRepository;
import br.com.datum.digio.repository.CompraRepository;
import br.com.datum.digio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InsertInitialConfig implements CommandLineRunner {

    @Value("${url.produtos}")
    private String urlProdutos;
    @Value("${url.compras}")
    private String urlCompras;

    private final RestTemplate restTemplate;

    private final ProdutoRepository produtoRepository;

    private final ClienteRepository clienteRepository;

    private final CompraRepository compraRepository;

    @Autowired
    public InsertInitialConfig(RestTemplate restTemplate, final ProdutoRepository produtoRepository,
            ClienteRepository clienteRepository,
            CompraRepository compraRepository) {
        this.restTemplate = restTemplate;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.compraRepository = compraRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        ProdutoDto[] lst = restTemplate.getForObject(urlProdutos, ProdutoDto[].class);
        for (ProdutoDto p : lst) {
            produtoRepository.save(p.toEntity());
        }
        ClienteDto[] lstCli = restTemplate.getForObject(urlCompras, ClienteDto[].class);
        for (ClienteDto c : lstCli) {
            var cliente = c.toEntity();
            clienteRepository.save(cliente);
            for (CompraDto cmp : c.getCompras()) {
                var compra = cmp.toEntity();
                compra.getId().setCliente(cliente);
                compraRepository.save(compra);
            }

        }


    }
}
