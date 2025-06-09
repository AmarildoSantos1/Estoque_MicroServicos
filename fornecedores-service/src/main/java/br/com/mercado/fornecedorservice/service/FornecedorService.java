package br.com.mercado.fornecedorservice.service;

import br.com.mercado.fornecedorservice.model.Fornecedor;
import br.com.mercado.fornecedorservice.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository repo;

    public Fornecedor salvar(Fornecedor obj) {
        return repo.save(obj);
    }

    public List<Fornecedor> listarTodos() {
        return repo.findAll();
    }

    public Fornecedor buscarOuFalhar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Fornecedor com ID " + id + " não encontrado."));
    }

    public void deletar(Long id) {
        buscarOuFalhar(id); // Garante que o fornecedor existe
        repo.deleteById(id);
    }
}
