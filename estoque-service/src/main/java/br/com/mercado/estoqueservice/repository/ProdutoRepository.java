package br.com.mercado.estoqueservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.estoqueservice.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
