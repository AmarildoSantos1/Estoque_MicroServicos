package br.com.mercado.funcionariosservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.funcionariosservice.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
