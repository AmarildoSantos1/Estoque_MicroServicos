package br.com.mercado.funcionariosservice.controller;

import br.com.mercado.funcionariosservice.model.Setor;
import br.com.mercado.funcionariosservice.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService service;

    @PostMapping
    public Setor salvar(@RequestBody Setor obj) {
        return service.salvar(obj);
    }

    @GetMapping
    public List<Setor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> buscarPorId(@PathVariable Long id) {
        Setor setor = service.buscarOuFalhar(id);
        return ResponseEntity.ok(setor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizar(@PathVariable Long id, @RequestBody Setor obj) {
        service.buscarOuFalhar(id); // verifica existência
        obj.setId(id);
        Setor atualizado = service.salvar(obj);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
