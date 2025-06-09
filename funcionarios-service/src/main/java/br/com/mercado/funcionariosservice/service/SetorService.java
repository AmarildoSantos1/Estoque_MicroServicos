package br.com.mercado.funcionariosservice.service;

import br.com.mercado.funcionariosservice.model.Setor;
import br.com.mercado.funcionariosservice.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository repo;

    public Setor salvar(Setor obj) {
        return repo.save(obj);
    }

    public List<Setor> listarTodos() {
        return repo.findAll();
    }

    public Setor buscarOuFalhar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Setor com ID " + id + " não encontrado."));
    }

    public void deletar(Long id) {
        buscarOuFalhar(id); // garante que existe
        repo.deleteById(id);
    }
}
