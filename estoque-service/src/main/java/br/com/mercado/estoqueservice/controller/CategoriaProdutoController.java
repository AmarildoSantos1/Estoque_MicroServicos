package br.com.mercado.estoqueservice.controller;

import br.com.mercado.estoqueservice.model.CategoriaProduto;
import br.com.mercado.estoqueservice.service.CategoriaProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaProdutoController {

    private final CategoriaProdutoService service;

    @PostMapping
    public CategoriaProduto salvar(@RequestBody CategoriaProduto obj) {
        return service.salvar(obj);
    }

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> buscarPorId(@PathVariable Long id) {
        CategoriaProduto categoria = service.buscarOuFalhar(id);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> atualizar(@PathVariable Long id, @RequestBody CategoriaProduto obj) {
        service.buscarOuFalhar(id); // Garante que existe, senão lança exceção
        obj.setId(id);
        CategoriaProduto atualizado = service.salvar(obj);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
