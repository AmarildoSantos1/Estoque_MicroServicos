package br.com.mercado.estoqueservice.controller;

import br.com.mercado.estoqueservice.model.Produto;
import br.com.mercado.estoqueservice.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public Produto salvar(@RequestBody Produto obj) {
        return service.salvar(obj);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto produto = service.buscarOuFalhar(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto obj) {
        service.buscarOuFalhar(id); // lança exceção se não existir
        obj.setId(id);
        Produto atualizado = service.salvar(obj);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
