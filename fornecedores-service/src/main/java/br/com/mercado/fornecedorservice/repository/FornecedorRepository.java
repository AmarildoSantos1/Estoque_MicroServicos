package br.com.mercado.fornecedorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.fornecedorservice.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
