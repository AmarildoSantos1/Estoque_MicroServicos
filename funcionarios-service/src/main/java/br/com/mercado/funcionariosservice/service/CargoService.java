package br.com.mercado.funcionariosservice.service;

import br.com.mercado.funcionariosservice.model.Cargo;
import br.com.mercado.funcionariosservice.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository repo;

    public Cargo salvar(Cargo obj) {
        return repo.save(obj);
    }

    public List<Cargo> listarTodos() {
        return repo.findAll();
    }

    public Cargo buscarOuFalhar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cargo com ID " + id + " não encontrado"));
    }

    public void deletar(Long id) {
        Cargo cargo = buscarOuFalhar(id); // Garante que o cargo existe antes de deletar
        repo.deleteById(id);
    }
}
