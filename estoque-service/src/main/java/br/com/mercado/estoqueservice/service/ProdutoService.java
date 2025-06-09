package br.com.mercado.estoqueservice.service;

import br.com.mercado.estoqueservice.model.Produto;
import br.com.mercado.estoqueservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repo;

    public Produto salvar(Produto obj) {
        return repo.save(obj);
    }

    public List<Produto> listarTodos() {
        return repo.findAll();
    }

    public Produto buscarOuFalhar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado."));
    }

    public void deletar(Long id) {
        buscarOuFalhar(id); // garante que o produto existe antes de deletar
        repo.deleteById(id);
    }
}
