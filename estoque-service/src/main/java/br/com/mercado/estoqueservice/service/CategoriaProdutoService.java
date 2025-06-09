package br.com.mercado.estoqueservice.service;

import br.com.mercado.estoqueservice.model.CategoriaProduto;
import br.com.mercado.estoqueservice.repository.CategoriaProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoriaProdutoService {

    private final CategoriaProdutoRepository repo;

    public CategoriaProduto salvar(CategoriaProduto obj) {
        return repo.save(obj);
    }

    public List<CategoriaProduto> listarTodos() {
        return repo.findAll();
    }

    public CategoriaProduto buscarOuFalhar(Long id) {
        return repo.findById(id).orElseThrow(() ->
            new NoSuchElementException("CategoriaProduto com ID " + id + " não encontrada."));
    }

    public void deletar(Long id) {
        buscarOuFalhar(id); // Garante que existe antes de deletar
        repo.deleteById(id);
    }
}
