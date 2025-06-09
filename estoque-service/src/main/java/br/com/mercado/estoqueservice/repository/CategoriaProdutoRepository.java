package br.com.mercado.estoqueservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.estoqueservice.model.CategoriaProduto;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
}
