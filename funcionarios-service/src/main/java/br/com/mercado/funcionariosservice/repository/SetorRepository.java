package br.com.mercado.funcionariosservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.funcionariosservice.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {
}
