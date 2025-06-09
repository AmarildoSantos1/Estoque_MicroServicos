package br.com.mercado.funcionariosservice.controller;

import br.com.mercado.funcionariosservice.model.Cargo;
import br.com.mercado.funcionariosservice.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;

    @PostMapping
    public ResponseEntity<Cargo> salvar(@RequestBody Cargo obj) {
        Cargo salvo = service.salvar(obj);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable Long id) {
        Cargo cargo = service.buscarOuFalhar(id);
        return ResponseEntity.ok(cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody Cargo obj) {
        service.buscarOuFalhar(id); // lança exceção se não encontrar
        obj.setId(id);
        Cargo atualizado = service.salvar(obj);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id); // lança exceção se não encontrar
        return ResponseEntity.noContent().build();
    }
}
