package br.com.mercado.estoqueservice.controller;

import br.com.mercado.estoqueservice.model.Produto;
import br.com.mercado.estoqueservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> listarEstoque() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/valor-total")
    public ResponseEntity<Double> valorTotal() {
        double total = produtoRepository.findAll()
                .stream()
                .mapToDouble(p -> {
                    double preco = p.getPrecoCusto();
                    int quantidade = p.getQuantidadeInicial(); // tipo primitivo, não precisa verificar null
                    return preco * quantidade;
                })
                .sum();
        return ResponseEntity.ok(total);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscarPorNomeOuCodigo(@RequestParam String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            throw new IllegalArgumentException("O parâmetro 'termo' é obrigatório.");
        }

        List<Produto> resultados = produtoRepository.findAll()
                .stream()
                .filter(p -> {
                    String nome = p.getNome() != null ? p.getNome() : "";
                    String codigo = p.getCodigoBarras() != null ? p.getCodigoBarras() : "";
                    return nome.contains(termo) || codigo.contains(termo);
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultados);
    }
}
